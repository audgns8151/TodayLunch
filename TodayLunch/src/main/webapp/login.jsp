<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=1366, maximum-scale=1.0" />
    <link rel="shortcut icon" type="image/png" href="https://animaproject.s3.amazonaws.com/home/favicon.png" />
    <meta name="og:type" content="website" />
    <meta name="twitter:card" content="photo" />
    <link rel="stylesheet" type="text/css" href="css/login.css" />
    <link rel="stylesheet" type="text/css" href="css/styleguide.css" />
    <link rel="stylesheet" type="text/css" href="css/globals.css" />
  </head>
  <body style="margin: 0; background: #d9c0a3">
    <input type="hidden" id="anPageName" name="page" value="login" />
    <div class="container-center-horizontal">
      <form class="login screen" name="form2" action="LoginService" method="post">
        <div class="overlap-group3">
          <div class="overlap-group">
            <div class="overlap-group">
              <img class="pizza" src="img/pizza@1x.png" />
              <div class="x9"></div>
            </div>
            <div class="text-1">
              <span class="span0"></span><span class="span1"></span
              ><span class="span2"><br /><br />오늘의 점심은? 오:점!</span>
            </div>
          </div>
          <div class="login-board">
            <div class="overlap-group2">
              <div class="sign-in gowundodum-normal-concrete-18px">회원가입</div>
              <div class="x11"></div>
              <div class="already-customer-of">아직 회원가입을 안하셨나요?</div>
              <a href="javascript:SubmitForm('form2')"> <div class="view"></div></a>
              <div class="text-2">로그인</div>
              <div class="password"></div>
              <a href="javascript:SubmitForm('form2')"> <div class="email"></div></a>
              <div class="text-3 gowundodum-normal-concrete-18px">패스워드</div>
              <div class="text-4 gowundodum-normal-concrete-18px">이메일</div>
              <div class="sign-in-1">LOGIN</div>
            </div>
          </div>
          <div class="footer">
            <div class="x291">
              <div class="frame-778">
                <div class="logo">
                  <div class="logo-1"><h1 class="fleet">오점: 오늘의 점심</h1></div>
                </div>
                <div class="nav-col-01">
                  <div class="frame-777 notosans-normal-concrete-16px">
                    <div class="about">About</div>
                    <div class="projects">Projects</div>
                  </div>
                </div>
                <div class="nav-col-02 notosans-normal-concrete-16px">
                  <div class="what-we-do">What We Do</div>
                  <div class="press">Press</div>
                </div>
                <div class="email-1">
                  <div class="single-input-field">
                    <div class="enter-your-email notosans-normal-concrete-16px">Enter your email</div>
                    <div class="small-circle-button">
                      <div class="icons-arrow-right-2-line"></div>
                    </div>
                  </div>
                </div>
              </div>
              <div class="copyright-2021-ui8 gowundodum-normal-concrete-18px">
                Copyright © 2022 인생모읍따 Co. Ltd.&nbsp;&nbsp;All rights reserved
              </div>
            </div>
          </div>
          <img class="hover" src="img/hover@1x.png" onclick="SubmitForm('form2');" />
         
    	<input class="enter-email-address" name="email" placeholder="" type="text" required /><input
            class="password-1"
            name="pw"
            placeholder="Password"
            type="password"
            required
          /> 
        </div>
      </form>
    </div>
    <script>
      /* Copyright (c) 2016 Tobias Buschor https://goo.gl/gl0mbf | MIT License https://goo.gl/HgajeK */

      if (!HTMLFormElement.prototype.reportValidity) {
        HTMLFormElement.prototype.reportValidity = function () {
          if (this.checkValidity()) return true;
          var btn = document.createElement("button");
          this.appendChild(btn);
          btn.click();
          this.removeChild(btn);
          return false;
        };
      }

      function SubmitForm(form_name) {
        var form = document.getElementsByName(form_name)[0];
        if (form.reportValidity()) {
          form.submit();
          if (window.submitted) window.submitted();
        }
      }
    </script>
  </body>
</html>