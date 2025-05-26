(function(){const v=document.createElement("link").relList;if(v&&v.supports&&v.supports("modulepreload"))return;for(const i of document.querySelectorAll('link[rel="modulepreload"]'))s(i);new MutationObserver(i=>{for(const o of i)if(o.type==="childList")for(const c of o.addedNodes)c.tagName==="LINK"&&c.rel==="modulepreload"&&s(c)}).observe(document,{childList:!0,subtree:!0});function y(i){const o={};return i.integrity&&(o.integrity=i.integrity),i.referrerPolicy&&(o.referrerPolicy=i.referrerPolicy),i.crossOrigin==="use-credentials"?o.credentials="include":i.crossOrigin==="anonymous"?o.credentials="omit":o.credentials="same-origin",o}function s(i){if(i.ep)return;i.ep=!0;const o=y(i);fetch(i.href,o)}})();(function(){const{createElement:n,Fragment:v}=React,{createRoot:y}=ReactDOM;function s(e){e.addEventListener("click",function(l){l.target===e&&e.close()})}window.closeModal=s;function i(){const e=document.querySelector(".modal1");if(!e){const t=document.createElement("div");t.innerHTML=`
      <dialog class="modal1">
      <div class="box_scroll" style="padding: 15px;">
            <table class="table table-hover">
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
        </div>
        </dialog>`,document.body.appendChild(t);const d=document.querySelector(".modal1");s(d)}const l=document.querySelector("#alert"),r=()=>{const t=l.getBoundingClientRect(),d=e.getBoundingClientRect();e.style.position="fixed",e.style.left=`${t.right-d.width}px`,e.style.top=`${t.bottom}px`};l.addEventListener("click",()=>{e.showModal(),r()}),window.addEventListener("resize",()=>{e.open&&r()})}function o(){const e=document.querySelector(".modal2");if(!e){const t=document.createElement("div");t.innerHTML=`
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
        </dialog>`,document.body.appendChild(t);const d=document.querySelector(".modal2");s(d)}document.querySelector("#friend").addEventListener("click",()=>{e.showModal()}),document.querySelectorAll(".lenCut_container").forEach(t=>{const d=t.querySelector(".lenCut"),u=t.querySelector(".lenCutE"),p=t.querySelector(".tooltip1");if(d){const a=d.textContent;a.length>6&&(d.textContent=a.slice(0,6)+"...",d.addEventListener("mouseenter",function(){p.style.display="block",p.textContent=a}),d.addEventListener("mouseleave",function(){p.style.display="none"}))}if(u){const a=u.textContent;a.length>15&&(u.textContent=a.slice(0,15)+"...",u.addEventListener("mouseenter",function(){p.style.display="block",p.textContent=a}),u.addEventListener("mouseleave",function(){p.style.display="none"}))}}),document.querySelectorAll(".button_select").forEach(t=>{let d=!1;t.addEventListener("click",()=>{d=!d,t.classList.toggle("active"),d?t.textContent="취소":t.textContent="선택"}),t.addEventListener("mouseenter",()=>{d&&(t.textContent="취소")}),t.addEventListener("mouseleave",()=>{d&&(t.textContent="선택")})})}function c(e){["1","2","3"].forEach(t=>{const d=document.getElementById(t);d&&(d.style.display=t===e?"block":"none")}),document.querySelectorAll(".button_friend").forEach((t,d)=>{(d+1).toString()===e?t.classList.add("active"):t.classList.remove("active")})}window.addEventListener("load",()=>c("1")),window.Watchdiv=c;function f(){confirm("로그아웃 하겠습니까?")&&(window.location.href="index.html")}window.logout=f;function g(){const e=document.querySelector(".modal3");if(!e){const t=document.createElement("div");t.innerHTML=`
      <dialog class="modal3">
        <div class="middle3">
                
            <div style="display: flex; justify-content: flex-end;" >
                <form method="dialog">
                    <button style="background-color:none; border:none;" class="font1">X</button>
                </form>
            </div>

            <div style="display: flex;">
                <img src="icon/user2.png" style="height:100px; width:100px; margin:10px; margin-right: 30px; margin-left: 20px"/>
                <div style="display: flex; flex-direction: column; justify-content: center; padding: 5px;">
                    <div style="display: flex; gap: 5px;">
                        <div class="black" style="font-size: larger;">닉네임</div>
                        <div style="color:green">#0000</div>
                    </div>
                    <div style="color:gray;">identification</div>
                    <div class="box_introduce">
                        자기소개ㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁ
                    </div>

                    <div style="display: flex; flex-direction: row; margin-top: 30px;">
                        <button class="button_pro" style="margin-right:5px;" onclick="window.location.href='profile.html';">프로필 수정</button>
                        <button class="button_pro" onclick="logout()">로그아웃</button>
                    </div>  

                </div>
            </div> 

        </div>  
      </dialog>`,document.body.appendChild(t);const d=document.querySelector(".modal3");s(d)}const l=document.querySelector("#mypage"),r=()=>{const t=l.getBoundingClientRect(),d=e.getBoundingClientRect();e.style.position="fixed",e.style.left=`${t.right-d.width}px`,e.style.top=`${t.bottom}px`};l.addEventListener("click",()=>{e.showModal(),r()}),window.addEventListener("resize",()=>{e.open&&r()})}function h(){window.location.href="projectlist.html"}function m(){return n("div",{className:"root"},n("button",{className:"left1 drag1 clear",onClick:h},n("img",{src:"icon/logo.png",className:"logo",style:{height:"50px"}})),n("button",{className:"right3 drag1 clear",onClick:g,id:"mypage"},n("i",{className:"fa-solid fa-user fa-2x",style:{fontSize:"25px"}})),n("button",{className:"right2 drag1 clear",onClick:o,id:"friend"},n("i",{className:"fa-solid fa-user-group fa-2x",style:{fontSize:"25px"}})),n("button",{className:"right1 drag1 clear",onClick:i,id:"alert"},n("i",{className:"fa-solid fa-bell fa-2x",style:{fontSize:"25px"}})))}y(document.getElementById("root")).render(n(m));let b=document.querySelector("#root"),x=new MutationObserver(()=>{i(),o(),g()});window.onload=function(){i(),o(),g()};let w={attributes:!0,childList:!0,characterData:!0};x.observe(b,w)})();
