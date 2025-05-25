(function(){const d=document.createElement("link").relList;if(d&&d.supports&&d.supports("modulepreload"))return;for(const t of document.querySelectorAll('link[rel="modulepreload"]'))l(t);new MutationObserver(t=>{for(const o of t)if(o.type==="childList")for(const a of o.addedNodes)a.tagName==="LINK"&&a.rel==="modulepreload"&&l(a)}).observe(document,{childList:!0,subtree:!0});function s(t){const o={};return t.integrity&&(o.integrity=t.integrity),t.referrerPolicy&&(o.referrerPolicy=t.referrerPolicy),t.crossOrigin==="use-credentials"?o.credentials="include":t.crossOrigin==="anonymous"?o.credentials="omit":o.credentials="same-origin",o}function l(t){if(t.ep)return;t.ep=!0;const o=s(t);fetch(t.href,o)}})();(function(){const{createElement:e,Fragment:d}=React,{createRoot:s}=ReactDOM;function l(i){i.addEventListener("click",function(c){c.target===i&&i.close()})}window.closeModal=l;function t(){const i=document.querySelector(".modal1");if(!i){const r=document.createElement("div");r.innerHTML=`<dialog class="modal1" style="overflow-y:scroll; ">
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
                                <img src="public/icon/trash.png" style="height: 20px; width: 20px; margin-top:55px;"/>
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
                                <img src="public/icon/trash.png" style="height: 20px; width: 20px; margin-top:55px;"/>
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
                                <img src="public/icon/trash.png" style="height: 20px; width: 20px; margin-top:55px;"/>
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
                                <img src="public/icon/trash.png" style="height: 20px; width: 20px; margin-top:55px;"/>
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
                                <img src="public/icon/trash.png" style="height: 20px; width: 20px; margin-top:55px;"/>
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
                                <img src="public/icon/trash.png" style="height: 20px; width: 20px; margin-top:55px;"/>
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
                                <img src="public/icon/trash.png" style="height: 20px; width: 20px; margin-top:55px;"/>
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
                                <img src="public/icon/trash.png" style="height: 20px; width: 20px; margin-top:55px;"/>
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
                                <img src="public/icon/trash.png" style="height: 20px; width: 20px; margin-top:55px;"/>
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
        </dialog>`,document.body.appendChild(r);const n=document.querySelector(".modal1");l(n)}document.querySelector("#alert").addEventListener("click",()=>{i.showModal()})}function o(){const i=document.querySelector(".modal2");if(!i){const r=document.createElement("div");r.innerHTML=`
        <dialog class="modal2" style="border: none; background-color: transparent;>
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
                                <th><img src="public/icon/user2.png" style="height: 25px; width: 25px; "/></th>
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
                        <img src="public/icon/finding.png" style="width: 25px; height: 25px; margin: 5px; margin-left: auto;"/>                    
                    </div>
            
            
                    <div class="box10">
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
                                        <img src="public/icon/user2.png" style="height: 30px; width: 30px; margin:5px;"/>
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
                                        <img src="public/icon/user2.png" style="height: 30px; width: 30px; margin:5px;"/>
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
                                <th><img src="public/icon/user2.png" style="height: 25px; width: 25px; margin:5px;"/></th>
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
        </dialog>`,document.body.appendChild(r);const n=document.querySelector(".modal2");l(n)}document.querySelector("#friend").addEventListener("click",()=>{i.showModal()})}function a(i){["1","2","3"].forEach(n=>{const p=document.getElementById(n);p&&(p.style.display=n===i?"block":"none")}),document.querySelectorAll(".button_friend").forEach((n,p)=>{(p+1).toString()===i?n.classList.add("active"):n.classList.remove("active")})}window.addEventListener("load",()=>a("1")),window.Watchdiv=a;function v(){confirm("로그아웃 하겠습니까?")&&(window.location.href="index.html")}window.logout=v;function u(){const i=document.querySelector(".modal3");if(!i){const r=document.createElement("div");r.innerHTML=`
      <dialog class="modal3">
        <div class="middle3">
        
            <div style="display: flex; justify-content: flex-end;" >
                <form method="dialog">
                    <button style="background-color:none; border:none;" class="font1">X</button>
                </form>
            </div>

            <div style="display: flex;">
                <img src="public/icon/user2.png" style="height:100px; width:100px; margin:30px;"/>
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
                <button class="button_pro" style="margin-right:5px;" onclick="window.location.href='profile.html';">프로필 수정</button>
                <button class="button_pro" onclick="logout()">로그아웃</button>
            </div>
        </div>  
      </dialog>`,document.body.appendChild(r);const n=document.querySelector(".modal3");l(n)}document.querySelector("#mypage").addEventListener("click",()=>{i.showModal()})}function y(){window.location.href="projectlist.html"}function b(){return e("div",{className:"root"},e("button",{className:"left1 drag1 clear",onClick:y},e("img",{src:"public/icon/logo.png",className:"logo",style:{height:"50px"}})),e("button",{className:"right3 drag1 clear",onClick:u,id:"mypage"},e("i",{className:"fa-solid fa-user fa-2x",style:{fontSize:"25px"}})),e("button",{className:"right2 drag1 clear",onClick:o,id:"friend"},e("i",{className:"fa-solid fa-user-group fa-2x",style:{fontSize:"25px"}})),e("button",{className:"right1 drag1 clear",onClick:t,id:"alert"},e("i",{className:"fa-solid fa-bell fa-2x",style:{fontSize:"25px"}})))}s(document.getElementById("root")).render(e(b));let h=document.querySelector("#root"),g=new MutationObserver(()=>{t(),o(),u()});window.onload=function(){t(),o(),u()};let f={attributes:!0,childList:!0,characterData:!0};g.observe(h,f)})();document.querySelectorAll(".lenCut_container").forEach(e=>{const d=e.querySelector(".lenCut"),s=e.querySelector(".lenCutE"),l=e.querySelector(".tooltip1");if(d){const t=d.textContent;t.length>6&&(d.textContent=t.slice(0,6)+"...",d.addEventListener("mouseenter",function(){l.style.display="block",l.textContent=t}),d.addEventListener("mouseleave",function(){l.style.display="none"}))}if(s){const t=s.textContent;t.length>15&&(s.textContent=t.slice(0,15)+"...",s.addEventListener("mouseenter",function(){l.style.display="block",l.textContent=t}),s.addEventListener("mouseleave",function(){l.style.display="none"}))}});const m=document.querySelectorAll(".button_select");m.forEach(e=>{let d=!1;e.addEventListener("click",()=>{d=!d,e.classList.toggle("active"),d?e.textContent="취소":e.textContent="선택"}),e.addEventListener("mouseenter",()=>{d&&(e.textContent="취소")}),e.addEventListener("mouseleave",()=>{d&&(e.textContent="선택")})});
