package com.sy.soyeon.utils;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.net.PrintCommandListener;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.SocketException;
import java.net.URLEncoder;

@Slf4j
@Component  // bean 생성
@PropertySource("classpath:config/props/ftpConf.properties")
public class FtpUtils {

    // @Value()안의 값이 변수값으로 들어감
    @Value("localhost")
    private String server;

    @Value("21")
    private int port;

    @Value("e7e")
    private String username;

    @Value("java")
    private String password;

    private FTPClient ftp;


    // 접속
    // FTPClient 객체를 통한 ftp 서버 연결
    public void open() throws SocketException, IOException {
        log.debug("server:" + server);
        log.debug("port:" + port);
        log.debug("username:" + username);
        log.debug("password:" + password);

        ftp = new FTPClient();
        ftp.setControlEncoding("UTF-8");

        // 로그로 서버와 주고받은 명령어 결과들을 출력받을 수 있음
        ftp.addProtocolCommandListener(new PrintCommandListener(new PrintWriter(System.out), true));

        ftp.connect(server, port);
        int reply = ftp.getReplyCode();
        if (!FTPReply.isPositiveCompletion(reply)) {
            ftp.disconnect();
            log.error("FTPClient:: server connection failed.");
        }

        ftp.setSoTimeout(1000);
        ftp.login(username, password);
        ftp.setFileType(FTP.BINARY_FILE_TYPE);
    }

    // 연결 해제
    public void close() throws IOException {
        ftp.logout();
        ftp.disconnect();
    }

    // 업로드
    // ftp 서버에 전송받은 파일 UPLOAD
    public void upload(MultipartFile file) throws IOException {
        open();
        InputStream inputStream = null;
        inputStream = file.getInputStream();

        // 아래 라인이 핵심, Put 같음
        ftp.storeFile(file.getOriginalFilename(), inputStream);
        inputStream.close();
        close();
    }

    // 다운로드
    public void download(String fname, HttpServletResponse resp) throws IOException {

        String fileName = URLEncoder.encode("fName", "UTF-8");
        // String fileName2 = "image1.png";

        // 브라우저 별 기본 세팅이 조금 다름. 아래는 크롬 기준.
        resp.setContentType("application/octet-stream");

        // 인코딩 된 값이 들어가야 함
        resp.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"");

        // ftp 연결
        open();

        OutputStream outputStream = new BufferedOutputStream(resp.getOutputStream());
        InputStream inputStream = null;

        // Get에 해당
        // 인코딩 안 된 값이 들어가야 함
        inputStream = ftp.retrieveFileStream("/" + fname);

        byte[] bytesArray = new byte[4096];
        int bytesRead = -1;
        while ((bytesRead = inputStream.read(bytesArray)) != -1) {
            outputStream.write(bytesArray, 0, bytesRead);
        }

        boolean success = ftp.completePendingCommand();
        log.debug("check: " + success);
        outputStream.close();
        inputStream.close();

        // ftp 연결 닫기
        close();
    }

}
