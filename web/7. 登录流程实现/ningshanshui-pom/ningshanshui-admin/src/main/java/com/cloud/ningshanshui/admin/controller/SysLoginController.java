package com.cloud.ningshanshui.admin.controller;

import com.cloud.ningshanshui.admin.model.SysUser;
import com.cloud.ningshanshui.admin.security.JwtAuthenticatioToken;
import com.google.code.kaptcha.Constants;
import com.google.code.kaptcha.Producer;
import com.cloud.ningshanshui.admin.service.SysUserService;
import com.cloud.ningshanshui.admin.util.PasswordUtils;
import com.cloud.ningshanshui.admin.util.SecurityUtils;
import com.cloud.ningshanshui.admin.vo.LoginBean;
import com.cloud.ningshanshui.common.utils.IOUtils;
import com.cloud.ningshanshui.core.http.HttpResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;


/**
 * <p>Title: 登录控制器</p>
 * <p>Company: 纬度网络能源</p>
 *
 * @version 1.0
 * @KaiFaAuthor 宁山水
 * @date 2020-03-25 9:18
 */

@RestController
public class SysLoginController {

    @Autowired
    private Producer producer;

    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @GetMapping("captcha.jpg")
    public void captcha(HttpServletResponse response, HttpServletRequest request) throws ServletException, IOException {
        response.setHeader("Cache-Control", "no-store, no-cache");
        response.setContentType("image/jpeg");

        // 生成文字验证码
        String text = producer.createText();
        System.out.println(text);
        // 生成图片验证码
        BufferedImage image = producer.createImage(text);
        // 保存到验证码到 session
        request.getSession().setAttribute(Constants.KAPTCHA_SESSION_KEY, text);

        ServletOutputStream out = response.getOutputStream();
        ImageIO.write(image, "jpg", out);
        IOUtils.closeQuietly(out);
    }

    /**
     * 登录接口
     */
    @PostMapping(value = "/login")
    public HttpResult login(@RequestBody LoginBean loginBean, HttpServletRequest request) throws IOException {
        String username = loginBean.getAccount();
        String password = loginBean.getPassword();
        String captcha = loginBean.getCaptcha();
        // 从session中获取之前保存的验证码跟前台传来的验证码进行匹配
        Object kaptcha = request.getSession().getAttribute(Constants.KAPTCHA_SESSION_KEY);
        if(kaptcha == null){
            return HttpResult.error("验证码已失效");
        }
        if(!captcha.equals(kaptcha)){
            return HttpResult.error("验证码不正确");
        }
        // 用户信息
        SysUser user = sysUserService.findByName(username);
        // 账号不存在、密码错误
        if (user == null) {
            return HttpResult.error("账号不存在");
        }
        if (!PasswordUtils.matches(user.getSalt(), password, user.getPassword())) {
            return HttpResult.error("密码不正确");
        }
        // 账号锁定
        if (user.getStatus() == 0) {
            return HttpResult.error("账号已被锁定,请联系管理员");
        }
        // 系统登录认证
        JwtAuthenticatioToken token = SecurityUtils.login(request, username, password, authenticationManager);
        return HttpResult.ok(token);
    }




















    /*@GetMapping("getHutool.jpg")
    public  void getHutool(HttpServletResponse response, HttpServletRequest request) throws Exception {
        //定义图形验证码的长、宽、验证码字符数、干扰线宽度
        response.setHeader("Cache-Control", "no-store, no-cache");
        response.setContentType("image/jpeg");
        ShearCaptcha captcha = CaptchaUtil.createShearCaptcha(200, 100, 4, 4);
        String text =  captcha.getCode();
        System.out.println(text);
        BufferedImage image = (BufferedImage) captcha.createImage(text);
        request.getSession().setAttribute("yanzhengma1", text);
        ServletOutputStream out = response.getOutputStream();
        ImageIO.write(image, "jpg", out);
        IOUtils.closeQuietly(out);
    }*/


    //public static void main(String[] args) {

        /*ShearCaptcha captcha = CaptchaUtil.createShearCaptcha(200, 100, 4, 4);
        String text =  captcha.getCode();
        System.out.println(text);
        BufferedImage image = (BufferedImage) captcha.createImage(text);
        System.out.println(image);*/

        // 线段干扰的验证码
        /*LineCaptcha lineCaptcha = CaptchaUtil.createLineCaptcha(200, 100);
        //图形验证码写出，可以写出到文件，也可以写出到流
        lineCaptcha.write("E:/line.png");
        //输出code
        Console.log(lineCaptcha.getCode());
        //验证图形验证码的有效性，返回boolean值
        lineCaptcha.verify("1234");

        //重新生成验证码
        lineCaptcha.createCode();
        lineCaptcha.write("E:/line.png");
        //新的验证码
        Console.log(lineCaptcha.getCode());
        //验证图形验证码的有效性，返回boolean值
        lineCaptcha.verify("1234");*/


        //圆圈干扰验证码
        //定义图形验证码的长、宽、验证码字符数、干扰元素个数
        /*CircleCaptcha captcha = CaptchaUtil.createCircleCaptcha(200, 100, 4, 20);
        //CircleCaptcha captcha = new CircleCaptcha(200, 100, 4, 20);
        //图形验证码写出，可以写出到文件，也可以写出到流
        captcha.write("E:/circle.png");
        //验证图形验证码的有效性，返回boolean值
        captcha.verify("1234");*/

        //
//        ICaptcha captcha = ...;
//        captcha.write(response.getOutputStream());
        //Servlet的OutputStream记得自行关闭哦！



        // 扭曲干扰验证码
        /*//定义图形验证码的长、宽、验证码字符数、干扰线宽度
        ShearCaptcha captcha = CaptchaUtil.createShearCaptcha(200, 100, 4, 4);
        //ShearCaptcha captcha = new ShearCaptcha(200, 100, 4, 4);
        //图形验证码写出，可以写出到文件，也可以写出到流
        captcha.write("E:/shear.png");
        //验证图形验证码的有效性，返回boolean值
        captcha.verify("1234");

        ICaptcha captcha1 = ...;

        captcha1.write(response.getOutputStream());
        //Servlet的OutputStream记得自行关闭哦！
*/


        //自定义验证码
        // 自定义纯数字的验证码（随机4位数字，可重复）
        //RandomGenerator randomGenerator = new RandomGenerator("0123456789", 4);
        //LineCaptcha lineCaptcha = CaptchaUtil.createLineCaptcha(200, 100);
        //captcha.setGenerator(randomGenerator);
        // 重新生成code
        //captcha.createCode();





    //}











}
