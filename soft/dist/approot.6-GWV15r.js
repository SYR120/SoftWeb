(function(){const c=document.createElement("link").relList;if(c&&c.supports&&c.supports("modulepreload"))return;for(const o of document.querySelectorAll('link[rel="modulepreload"]'))r(o);new MutationObserver(o=>{for(const l of o)if(l.type==="childList")for(const a of l.addedNodes)a.tagName==="LINK"&&a.rel==="modulepreload"&&r(a)}).observe(document,{childList:!0,subtree:!0});function p(o){const l={};return o.integrity&&(l.integrity=o.integrity),o.referrerPolicy&&(l.referrerPolicy=o.referrerPolicy),o.crossOrigin==="use-credentials"?l.credentials="include":o.crossOrigin==="anonymous"?l.credentials="omit":l.credentials="same-origin",l}function r(o){if(o.ep)return;o.ep=!0;const l=p(o);fetch(o.href,l)}})();(function(){const{createElement:s,Fragment:c}=React,{createRoot:p}=ReactDOM;function r(t){t.addEventListener("click",function(e){e.target===t&&t.close()})}window.closeModal=r;function o(){const t=document.querySelector(".modal1");if(!t){const d=document.createElement("div");d.innerHTML=`<dialog class="modal1" style="overflow-y:scroll; ">
              <table class="table table-hover">
                  <thead>
                      <tr>
                          <th></th>
                          <th></th>
                      </tr>
                  </thead>
                  <tbody>
                      <tr>
                          <td>
                              <div style="display: flex;">
                                  <div>프로젝트 1에 업무가 추가되었습니다.</div>
                              </div>
                              <br/>
                              <div style="display: flex;">
                                  <div style="font-size: small;">2025/05/05 12:00</div>
                              </div>
                          </td>
                          <td>
                              <div>
                                  <img src="icon/trash.png" style="height: 20px; width: 20px; margin-top:55px;"/>
                              </div>
                          </td>
                      </tr>
                      <tr>
                          <td>
                              <div style="display: flex;">
                                  <div>QWER님께서 친구를 요청합니다.</div>
                                  <button style="margin-left:10px;" class="button_ale">수락</button>
                                  <button style="margin-left:5px;" class="button_ale">거부</button>
                              </div>
                              <br/>
                              <div style="display: flex;">
                                  <div style="font-size: small;">2025/05/05 12:00</div>
                              </div>
                          </td>
                          <td>
                              <div>
                                  <img src="icon/trash.png" style="height: 20px; width: 20px; margin-top:55px;"/>
                              </div>
                          </td> 
                      </tr>
                      <tr>
                          <td>
                              <div style="display: flex;">
                                  <div>프로젝트 2에 초대되었습니다.</div>
                                  <div style="margin-left:10px;">(초대 유저: asdf12)</div>
                                  <button style="margin-left:10px;" class="button_ale">수락</button>
                                  <button style="margin-left:5px;" class="button_ale">거부</button>
                              </div>
                              <br/>
                              <div style="display: flex;">
                                  <div style="font-size: small;">2025/05/05 12:00</div>
                              </div>
                          </td>
                          <td>
                              <div>
                                  <img src="icon/trash.png" style="height: 20px; width: 20px; margin-top:55px;"/>
                              </div>
                          </td> 
                      </tr>
                      <tr>
                          <td>
                              <div style="display: flex;">
                                  <div>프로젝트 1에 업무가 추가되었습니다.</div>
                              </div>
                              <br/>
                              <div style="display: flex;">
                                  <div style="font-size: small;">2025/05/05 12:00</div>
                              </div>
                          </td>
                          <td>
                              <div>
                                  <img src="icon/trash.png" style="height: 20px; width: 20px; margin-top:55px;"/>
                              </div>
                          </td>
                      </tr>
                      <tr>
                          <td>
                              <div style="display: flex;">
                                  <div>프로젝트 2에 업무가 추가되었습니다.</div>
                              </div>
                              <br/>
                              <div style="display: flex;">
                                  <div style="font-size: small;">2025/05/05 12:00</div>
                              </div>
                          </td>
                          <td>
                              <div>
                                  <img src="icon/trash.png" style="height: 20px; width: 20px; margin-top:55px;"/>
                              </div>
                          </td>
                      </tr>
                      <tr>
                          <td>
                              <div style="display: flex;">
                                  <div>스크롤 확인용1</div>
                              </div>
                              <br/>
                              <div style="display: flex;">
                                  <div style="font-size: small;">2025/05/05 12:00</div>
                              </div>
                          </td>
                          <td>
                              <div>
                                  <img src="icon/trash.png" style="height: 20px; width: 20px; margin-top:55px;"/>
                              </div>
                          </td>
                      </tr>
                      <tr>
                          <td>
                              <div style="display: flex;">
                                  <div>스크롤 확인용1</div>
                              </div>
                              <br/>
                              <div style="display: flex;">
                                  <div style="font-size: small;">2025/05/05 12:00</div>
                              </div>
                          </td>
                          <td>
                              <div>
                                  <img src="icon/trash.png" style="height: 20px; width: 20px; margin-top:55px;"/>
                              </div>
                          </td>
                      </tr>
                      <tr>
                          <td>
                              <div style="display: flex;">
                                  <div>스크롤 확인용1</div>
                              </div>
                              <br/>
                              <div style="display: flex;">
                                  <div style="font-size: small;">2025/05/05 12:00</div>
                              </div>
                          </td>
                          <td>
                              <div>
                                  <img src="icon/trash.png" style="height: 20px; width: 20px; margin-top:55px;"/>
                              </div>
                          </td>
                      </tr>
                      <tr>
                          <td>
                              <div style="display: flex;">
                                  <div>스크롤 확인용1</div>
                              </div>
                              <br/>
                              <div style="display: flex;">
                                  <div style="font-size: small;">2025/05/05 12:00</div>
                              </div>
                          </td>
                          <td>
                              <div>
                                  <img src="icon/trash.png" style="height: 20px; width: 20px; margin-top:55px;"/>
                              </div>
                          </td>
                      </tr>
                  </tbody>
              </table>
              <div style="display: flex; justify-content: flex-end; ">
                  <form method="dialog">
                      <button style="background-color:none; border:none;" class="font1">닫기</button>
                  </form>  
              </div>
          </dialog>`,document.body.appendChild(d);const i=document.querySelector(".modal1");r(i)}document.querySelector("#alert").addEventListener("click",()=>{t.showModal()})}function l(){if(!document.querySelector(".modal2")){const d=document.createElement("div");d.innerHTML=`
          <dialog class="modal2" style="border: none; background-color: transparent;">
              <div style="margin-top:30px;">
                  <div>
                      <button class="button_friend" onclick="Watchdiv('1')">친구 목록</button>
                  </div>
                  <div>
                      <button class="button_friend" onclick="Watchdiv('2')">유저 찾기</button>
                  </div>
                  <div>
                      <button class="button_friend" onclick="Watchdiv('3')">요청 대기</button>
                  </div>
              </div>
              <div>
              <div class="box_friend">
                  <div id="1">
                      <div class="green" style="text-align: center;">친구 목록</div>
                      <div style="width: 100%;">
                          <hr style="border: 1px solid rgb(0, 0, 0); "/>
                      </div>
                      <table class="table table-hover">
                          <thead>
                              <tr>
                                  <th><img src="icon/user2.png" style="height: 25px; width: 25px; "/></th>
                                  <th>닉네임</th>
                                  <th>#태그</th>
                                  <th>마지막 접속시간</th>
                              </tr>
                          </thead>
                          <tbody>
                              <tr>
                                  <td>1</td>
                                  <td>1</td>
                                  <td>1</td>
                                  <td>1</td>
                              </tr>
                              <tr>
                                  <td>1</td>
                                  <td>1</td>
                                  <td>1</td>
                                  <td>1</td>
                              </tr>
                              <tr>
                                  <td>1</td>
                                  <td>1</td>
                                  <td>1</td>
                                  <td>1</td>
                              </tr>
                              <tr>
                                  <td>1</td>
                                  <td>1</td>
                                  <td>1</td>
                                  <td>1</td>
                              </tr>
                          </tbody>
                      </table>
                  </div>
  
                  <div id="2">
                      <div class="green">유저 찾기</div>
            
                    <div class="container_radio">
                        <input type="radio" name="option" style="height:15px; width:15px; margin: 5px;" checked="checked"><span>친구</span>
                        <input type="radio" name="option" style="height:15px; width:15px; margin: 5px; margin-left: 35px;"><span>전체</span>
                    </div>
            
                    <div class="find3">
                        <input class="button_find3" type="text" id="find" placeholder="아이디 / 태그로 유저 검색" style="font-size: small; width: 400px;"/> 
                        <img src="icon/finding.png" style="width: 25px; height: 25px; margin: 5px; margin-left: auto;"/>                    
                    </div>
            
            
                    <div class="box10">
                    <div class="box_scroll">
                        <table class="table table-hover" style="border-collapse: separate; border-spacing: 0;">
                            <thead>
                                <tr>
                                    <th style="width: 55px;"></th>
                                    <th style="width: 100px;">닉네임</th>
                                    <th style="width: 100px;">아이디</th>
                                    <th style="width: 60px;">#태그</th>
                                    <th style="width: 50px;">선택</th>
                                    <!-- <img src="icon/plus.png" style="height: 15px; width: 15px;"/> -->
                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                    <td>
                                        <img src="icon/user2.png" style="height: 30px; width: 30px; margin:5px;"/>
                                    </td>
                                    <td class="lenCut_container">
                                        <span class="lenCut">닉네임이아주아주아주길어요</span>
                                        <div class="tooltip1" id="tooltip"></div>                                                      
                                    </td>
                                    <td>
                                        <div class="lenCut_container">
                                            <span class="lenCutE" style="font-size: small; color: rgba(0, 0, 0, 0.5);">identification123</span>                            
                                            <div class="tooltip1" id="tooltip"></div>                                        
                                        </div>                            
                                    </td>
                                    <td>
                                        <span style="color: #3a6b5b;">#0000</span>                               
                                    </td>  
                                    <td>
                                        <button class="button_select">선택</button>
                                    </td>                           
                                </tr>
                                <tr>
                                    <td>
                                        <img src="icon/user2.png" style="height: 30px; width: 30px; margin:5px;"/>
                                    </td>
                                    <td class="lenCut_container">
                                        <span class="lenCut">정예은</span>
                                        <div class="tooltip1" id="tooltip"></div>                                                      
                                    </td>
                                    <td>
                                        <div class="lenCut_container">
                                            <span class="lenCutE" style="font-size: small; color: rgba(0, 0, 0, 0.5);">yeeun13</span>                            
                                            <div class="tooltip1" id="tooltip"></div>                                        
                                        </div>                            
                                    </td>
                                    <td>
                                        <span style="color: #3a6b5b;">#3697</span>                               
                                    </td>  
                                    <td>
                                        <button class="button_select">선택</button>
                                    </td>                           
                                </tr>
                                <tr><td>
                                    스크롤 테스트용 아무말 ㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁ
                                    ㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁ
                                </td></tr>
                            </tbody>
                        </table>
                    </div>
                    </div>
                    <br/>
                    <div>
                        <button class="button_final">선택완료</button>
                    </div>
                  </div>
                  <div id="3">
                      <div class="green" style="text-align: center;">요청 대기</div>
                      <div style="width: 100%;">
                          <hr style="border: 1px solid rgb(0, 0, 0); "/>
                      </div>
                      <table class="table table-hover">
                          <thead>
                              <tr>
                                  <th><img src="icon/user2.png" style="height: 25px; width: 25px; margin:5px;"/></th>
                                  <th>닉네임</th>
                                  <th>#태그</th>
                                  <th>수락</th>
                                  <th>거절</th>
                              </tr>
                          </thead>
                          <tbody>
                              <tr>
                              <td>1</td>
                              <td>1</td>
                              <td>1</td>
                              <td><button style="background-color:rgb(55,158,144);">수락</button></td>
                              <td><button style="background-color:rgb(255,127,127);">거절</button></td>
                          </tr>
                          <tr>
                              <td>1</td>
                              <td>1</td>
                              <td>1</td>
                              <td><button style="background-color:rgb(55,158,144);">수락</button></td>
                              <td><button style="background-color:rgb(255,127,127);">거절</button></td>
                          </tr>
                          <tr>
                              <td>1</td>
                              <td>1</td>
                              <td>1</td>
                              <td><button style="background-color:rgb(55,158,144);">수락</button></td>
                              <td><button style="background-color:rgb(255,127,127);">거절</button></td>
                          </tr>
                          <tr>
                              <td>1</td>
                              <td>1</td>
                              <td>1</td>
                              <td><button style="background-color:rgb(55,158,144);">수락</button></td>
                              <td><button style="background-color:rgb(255,127,127);">거절</button></td>
                          </tr>
                          </tbody>
                      </table>
                  </div>
                </div>
              </div>
              <div style="display: flex; justify-content: flex-end; margin-top:450px; ">
                  <form method="dialog">
                      <button style="background-color:none; border:none;" class="font1">닫기</button>
                  </form>  
              </div>
          </dialog>`,document.body.appendChild(d);const i=document.querySelector(".modal2");r(i)}const e=document.querySelector("#friend");e&&e.addEventListener("click",()=>{const d=document.querySelector(".modal2");d&&d.showModal()})}function a(t){["1","2","3"].forEach(i=>{const n=document.getElementById(i);n&&(n.style.display=i===t?"block":"none")}),document.querySelectorAll(".button_friend").forEach((i,n)=>{(n+1).toString()===t?i.classList.add("active"):i.classList.remove("active")})}window.addEventListener("load",()=>a("1")),window.Watchdiv=a;function y(){confirm("로그아웃 하겠습니까?")&&fetch("/api/auth/logout",{method:"POST"}).then(e=>{e.ok?window.location.href="/front/login.html?logout":alert("로그아웃에 실패했습니다. 다시 시도해주세요.")}).catch(e=>{console.error("Logout error:",e),alert("로그아웃 중 오류가 발생했습니다.")})}window.logout=y;function u(){if(!document.querySelector(".modal3")){const d=document.createElement("div");d.innerHTML=`
        <dialog class="modal3">
          <div class="middle3">
              <div style="display: flex; justify-content: flex-end;" >
                  <form method="dialog">
                      <button style="background-color:none; border:none;" class="font1">X</button>
                  </form>
              </div>
              <div style="display: flex;">
                  <img src="icon/user2.png" style="height:100px; width:100px; margin:30px;"/>
                  <div style="margin:50px ;">
                      <div class="black">닉네임</div>
                      <div style="display: flex;">
                          <div style="color:green">아이디</div>
                          <div style="color:green">#태그</div>
                      </div>
                      <div>자기소개</div>
                  </div>
              </div>
              <div style="display: flex; justify-content: flex-end; margin:5px 5px 0 0; ">
                  <button class="button_pro" style="margin-right:5px;" onclick="window.location.href='/front/profile.html'; document.querySelector('.modal3').close();">프로필 수정</button>
                  <button class="button_pro" onclick="logout()">로그아웃</button>
              </div>
          </div>  
        </dialog>`,document.body.appendChild(d);const i=document.querySelector(".modal3");r(i)}const e=document.querySelector("#mypage");e&&e.addEventListener("click",()=>{const d=document.querySelector(".modal3");d&&d.showModal()})}function h(){window.location.href="/front/projectlist.html"}function f(){return s("div",{className:"root"},s("button",{className:"left1 drag1 clear",onClick:h},s("img",{src:"icon/logo.png",className:"logo",style:{height:"50px"}})),s("button",{className:"right3 drag1 clear",onClick:u,id:"mypage"},s("i",{className:"fa-solid fa-user fa-2x",style:{fontSize:"25px"}})),s("button",{className:"right2 drag1 clear",onClick:l,id:"friend"},s("i",{className:"fa-solid fa-user-group fa-2x",style:{fontSize:"25px"}})),s("button",{className:"right1 drag1 clear",onClick:o,id:"alert"},s("i",{className:"fa-solid fa-bell fa-2x",style:{fontSize:"25px"}})))}p(document.getElementById("root")).render(s(f));let v=document.querySelector("#root");if(v){let t=new MutationObserver(()=>{o(),l(),u()});window.onload=function(){o(),l(),u()};let e={attributes:!0,childList:!0,characterData:!0};t.observe(v,e)}document.querySelectorAll(".lenCut_container").forEach(t=>{const e=t.querySelector(".lenCut"),d=t.querySelector(".lenCutE"),i=t.querySelector(".tooltip1");if(e){const n=e.textContent;n.length>6&&(e.textContent=n.slice(0,6)+"...",i&&(e.addEventListener("mouseenter",function(){i.style.display="block",i.textContent=n}),e.addEventListener("mouseleave",function(){i.style.display="none"})))}if(d){const n=d.textContent;n.length>15&&(d.textContent=n.slice(0,15)+"...",i&&(d.addEventListener("mouseenter",function(){i.style.display="block",i.textContent=n}),d.addEventListener("mouseleave",function(){i.style.display="none"})))}}),document.querySelectorAll(".button_select").forEach(t=>{let e=!1;t.addEventListener("click",()=>{e=!e,t.classList.toggle("active"),e?t.textContent="취소":t.textContent="선택"}),t.addEventListener("mouseenter",()=>{e&&(t.textContent="취소")}),t.addEventListener("mouseleave",()=>{e&&(t.textContent="선택")})})})();
