package com.sy.soyeon.controller;

import com.sy.soyeon.utils.FtpUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping("/ftp")
public class FtpController {

    private final FtpUtils ftpUtils;

    public FtpController(FtpUtils ftpUtils) {
        this.ftpUtils = ftpUtils;
    }

    @PostMapping("/uploadTest")
    @ResponseBody
    public String uploadTest(MultipartFile myFile) throws IOException {
        ftpUtils.upload(myFile);
        return "OK";
    }

    @GetMapping("/main")
    public String main() {
        return "ftpmain";
    }

    @GetMapping("/download/{fname}")
    public void download(@PathVariable String fname, HttpServletResponse resp) throws IOException {
        ftpUtils.download(fname, resp);
    }
}
