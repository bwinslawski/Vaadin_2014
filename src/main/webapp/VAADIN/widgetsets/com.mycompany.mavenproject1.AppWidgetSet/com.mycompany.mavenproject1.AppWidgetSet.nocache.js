function com_mycompany_mavenproject1_AppWidgetSet(){var N='bootstrap',O='begin',P='gwt.codesvr.com.mycompany.mavenproject1.AppWidgetSet=',Q='gwt.codesvr=',R='com.mycompany.mavenproject1.AppWidgetSet',S='startup',T='DUMMY',U=0,V='body',W='iframe',X='javascript:""',Y='position:absolute; width:0; height:0; border:none; left: -1000px;',Z=' top: -1000px;',$='CSS1Compat',_='<!doctype html>',ab='',bb='<html><head><\/head><body><\/body><\/html>',cb='undefined',db=/loaded|complete/,eb='DOMContentLoaded',fb=50,gb='Chrome',hb='eval("',ib=1,jb='");',kb='script',lb='javascript',mb='moduleStartup',nb='moduleRequested',ob='head',pb='meta',qb='name',rb='com.mycompany.mavenproject1.AppWidgetSet::',sb='::',tb='gwt:property',ub='content',vb='=',wb='gwt:onPropertyErrorFn',xb='Bad handler "',yb='" for "gwt:onPropertyErrorFn"',zb='gwt:onLoadErrorFn',Ab='" for "gwt:onLoadErrorFn"',Bb='#',Cb='?',Db='/',Eb=/^\w+:\/\//,Fb='img',Gb='clear.cache.gif',Hb='baseUrl',Ib='com.mycompany.mavenproject1.AppWidgetSet.nocache.js',Jb='base',Kb='//',Lb=/^\//,Mb=/^[a-zA-Z]+:\/\//,Nb='user.agent',Ob='opera',Pb='webkit',Qb='safari',Rb='msie',Sb=10,Tb='ie10',Ub=9,Vb='ie9',Wb=8,Xb='ie8',Yb='gecko',Zb='gecko1_8',$b='unknown',_b=2,ac=3,bc=4,cc=5,dc='selectingPermutation',ec='com.mycompany.mavenproject1.AppWidgetSet.devmode.js',fc='959F333043F4FC191EFB6D0E98A62A16',gc=':1',hc=':2',ic=':3',jc=':4',kc=':5',lc=':',mc='.cache.js',nc='loadExternalRefs',oc='end',pc='http:',qc='file:',rc='__gwtDevModeHook:com.mycompany.mavenproject1.AppWidgetSet',sc=/^http:\/\/(localhost|127\.0\.0\.1)(:\d+)?\/.*$/,tc='Ignoring non-whitelisted Dev Mode URL: ',uc=':moduleBase';var o=window;var p=document;r(N,O);function q(){var a=o.location.search;return a.indexOf(P)!=-1||a.indexOf(Q)!=-1}
function r(a,b){if(o.__gwtStatsEvent){o.__gwtStatsEvent({moduleName:R,sessionId:o.__gwtStatsSessionId,subSystem:S,evtGroup:a,millis:(new Date).getTime(),type:b})}}
com_mycompany_mavenproject1_AppWidgetSet.__sendStats=r;com_mycompany_mavenproject1_AppWidgetSet.__moduleName=R;com_mycompany_mavenproject1_AppWidgetSet.__errFn=null;com_mycompany_mavenproject1_AppWidgetSet.__moduleBase=T;com_mycompany_mavenproject1_AppWidgetSet.__softPermutationId=U;com_mycompany_mavenproject1_AppWidgetSet.__computePropValue=null;com_mycompany_mavenproject1_AppWidgetSet.__getPropMap=null;com_mycompany_mavenproject1_AppWidgetSet.__gwtInstallCode=function(){};com_mycompany_mavenproject1_AppWidgetSet.__gwtStartLoadingFragment=function(){return null};com_mycompany_mavenproject1_AppWidgetSet.__gwt_isKnownPropertyValue=function(){return false};com_mycompany_mavenproject1_AppWidgetSet.__gwt_getMetaProperty=function(){return null};__propertyErrorFunction=null;var s=o.__gwt_activeModules=o.__gwt_activeModules||{};s[R]={moduleName:R};var t;function u(){w();return t}
function v(){w();return t.getElementsByTagName(V)[U]}
function w(){if(t){return}var a=p.createElement(W);a.src=X;a.id=R;a.style.cssText=Y+Z;a.tabIndex=-1;p.body.appendChild(a);t=a.contentDocument;if(!t){t=a.contentWindow.document}t.open();var b=document.compatMode==$?_:ab;t.write(b+bb);t.close()}
function A(k){function l(a){function b(){if(typeof p.readyState==cb){return typeof p.body!=cb&&p.body!=null}return db.test(p.readyState)}
var c=b();if(c){a();return}function d(){if(!c){c=true;a();if(p.removeEventListener){p.removeEventListener(eb,d,false)}if(e){clearInterval(e)}}}
if(p.addEventListener){p.addEventListener(eb,d,false)}var e=setInterval(function(){if(b()){d()}},fb)}
function m(c){function d(a,b){a.removeChild(b)}
var e=v();var f=u();var g;if(navigator.userAgent.indexOf(gb)>-1&&window.JSON){var h=f.createDocumentFragment();h.appendChild(f.createTextNode(hb));for(var i=U;i<c.length;i++){var j=window.JSON.stringify(c[i]);h.appendChild(f.createTextNode(j.substring(ib,j.length-ib)))}h.appendChild(f.createTextNode(jb));g=f.createElement(kb);g.language=lb;g.appendChild(h);e.appendChild(g);d(e,g)}else{for(var i=U;i<c.length;i++){g=f.createElement(kb);g.language=lb;g.text=c[i];e.appendChild(g);d(e,g)}}}
com_mycompany_mavenproject1_AppWidgetSet.onScriptDownloaded=function(a){l(function(){m(a)})};r(mb,nb);var n=p.createElement(kb);n.src=k;p.getElementsByTagName(ob)[U].appendChild(n)}
com_mycompany_mavenproject1_AppWidgetSet.__startLoadingFragment=function(a){return D(a)};com_mycompany_mavenproject1_AppWidgetSet.__installRunAsyncCode=function(a){var b=v();var c=u().createElement(kb);c.language=lb;c.text=a;b.appendChild(c);b.removeChild(c)};function B(){var c={};var d;var e;var f=p.getElementsByTagName(pb);for(var g=U,h=f.length;g<h;++g){var i=f[g],j=i.getAttribute(qb),k;if(j){j=j.replace(rb,ab);if(j.indexOf(sb)>=U){continue}if(j==tb){k=i.getAttribute(ub);if(k){var l,m=k.indexOf(vb);if(m>=U){j=k.substring(U,m);l=k.substring(m+ib)}else{j=k;l=ab}c[j]=l}}else if(j==wb){k=i.getAttribute(ub);if(k){try{d=eval(k)}catch(a){alert(xb+k+yb)}}}else if(j==zb){k=i.getAttribute(ub);if(k){try{e=eval(k)}catch(a){alert(xb+k+Ab)}}}}}__gwt_getMetaProperty=function(a){var b=c[a];return b==null?null:b};__propertyErrorFunction=d;com_mycompany_mavenproject1_AppWidgetSet.__errFn=e}
function C(){function e(a){var b=a.lastIndexOf(Bb);if(b==-1){b=a.length}var c=a.indexOf(Cb);if(c==-1){c=a.length}var d=a.lastIndexOf(Db,Math.min(c,b));return d>=U?a.substring(U,d+ib):ab}
function f(a){if(a.match(Eb)){}else{var b=p.createElement(Fb);b.src=a+Gb;a=e(b.src)}return a}
function g(){var a=__gwt_getMetaProperty(Hb);if(a!=null){return a}return ab}
function h(){var a=p.getElementsByTagName(kb);for(var b=U;b<a.length;++b){if(a[b].src.indexOf(Ib)!=-1){return e(a[b].src)}}return ab}
function i(){var a=p.getElementsByTagName(Jb);if(a.length>U){return a[a.length-ib].href}return ab}
function j(){var a=p.location;return a.href==a.protocol+Kb+a.host+a.pathname+a.search+a.hash}
var k=g();if(k==ab){k=h()}if(k==ab){k=i()}if(k==ab&&j()){k=e(p.location.href)}k=f(k);return k}
function D(a){if(a.match(Lb)){return a}if(a.match(Mb)){return a}return com_mycompany_mavenproject1_AppWidgetSet.__moduleBase+a}
function F(){var f=[];var g=U;function h(a,b){var c=f;for(var d=U,e=a.length-ib;d<e;++d){c=c[a[d]]||(c[a[d]]=[])}c[a[e]]=b}
var i=[];var j=[];function k(a){var b=j[a](),c=i[a];if(b in c){return b}var d=[];for(var e in c){d[c[e]]=e}if(__propertyErrorFunc){__propertyErrorFunc(a,d,b)}throw null}
j[Nb]=function(){var a=navigator.userAgent.toLowerCase();if(function(){return a.indexOf(Ob)!=-1}())return Ob;if(function(){return a.indexOf(Pb)!=-1}())return Qb;if(function(){return a.indexOf(Rb)!=-1&&p.documentMode==Sb}())return Tb;if(function(){return a.indexOf(Rb)!=-1&&p.documentMode>=Ub}())return Vb;if(function(){return a.indexOf(Rb)!=-1&&p.documentMode>=Wb}())return Xb;if(function(){return a.indexOf(Yb)!=-1}())return Zb;return $b};i[Nb]={gecko1_8:U,ie10:ib,ie8:_b,ie9:ac,opera:bc,safari:cc};__gwt_isKnownPropertyValue=function(a,b){return b in i[a]};com_mycompany_mavenproject1_AppWidgetSet.__getPropMap=function(){var a={};for(var b in i){if(i.hasOwnProperty(b)){a[b]=k(b)}}return a};com_mycompany_mavenproject1_AppWidgetSet.__computePropValue=k;o.__gwt_activeModules[R].bindings=com_mycompany_mavenproject1_AppWidgetSet.__getPropMap;r(N,dc);if(q()){return D(ec)}var l;try{h([Zb],fc);h([Tb],fc+gc);h([Xb],fc+hc);h([Vb],fc+ic);h([Ob],fc+jc);h([Qb],fc+kc);l=f[k(Nb)];var m=l.indexOf(lc);if(m!=-1){g=parseInt(l.substring(m+ib),Sb);l=l.substring(U,m)}}catch(a){}com_mycompany_mavenproject1_AppWidgetSet.__softPermutationId=g;return D(l+mc)}
function G(){if(!o.__gwt_stylesLoaded){o.__gwt_stylesLoaded={}}r(nc,O);r(nc,oc)}
B();com_mycompany_mavenproject1_AppWidgetSet.__moduleBase=C();s[R].moduleBase=com_mycompany_mavenproject1_AppWidgetSet.__moduleBase;var H=F();if(o){var I=!!(o.location.protocol==pc||o.location.protocol==qc);o.__gwt_activeModules[R].canRedirect=I;if(I){var J=rc;var K=o.sessionStorage[J];if(!sc.test(K)){if(K&&(window.console&&console.log)){console.log(tc+K)}K=ab}if(K&&!o[J]){o[J]=true;o[J+uc]=C();var L=p.createElement(kb);L.src=K;var M=p.getElementsByTagName(ob)[U];M.insertBefore(L,M.firstElementChild||M.children[U]);return false}}}G();r(N,oc);A(H);return true}
com_mycompany_mavenproject1_AppWidgetSet.succeeded=com_mycompany_mavenproject1_AppWidgetSet();