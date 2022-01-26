/**
 * 
 */

var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
    mapOption = { 
        center: new kakao.maps.LatLng(35.149780435451, 126.91993932993827), // 지도의 중심좌표
        level: 3 // 지도의 확대 레벨
    };

// 지도를 표시할 div와  지도 옵션으로  지도를 생성합니다
var map = new kakao.maps.Map(mapContainer, mapOption);

function setCenter() {            
    // 이동할 위도 경도 위치를 생성합니다 

	var movelocation=document.getElementById('list').value
	
	console.log(movelocation)
	
	if(movelocation=="1"){
		 var moveLatLon = new kakao.maps.LatLng( 35.15881344951873, 126.85198351652691);
	}else{
		 var moveLatLon = new kakao.maps.LatLng( 35.149780435451, 126.91993932993827);
	}
   
	//클릭한 위치의 위도는 35.15881344951873 이고, 경도는 126.85198351652691 입니다
    
    // 지도 중심을 이동 시킵니다
    map.setCenter(moveLatLon);
}

// 지도에 클릭 이벤트를 등록합니다
// 지도를 클릭하면 마지막 파라미터로 넘어온 함수를 호출합니다
kakao.maps.event.addListener(map, 'click', function(mouseEvent) {        
    
    // 클릭한 위도, 경도 정보를 가져옵니다 
    var latlng = mouseEvent.latLng;
    
    var message = '클릭한 위치의 위도는 ' + latlng.getLat() + ' 이고, ';
    message += '경도는 ' + latlng.getLng() + ' 입니다';
    
    var resultDiv = document.getElementById('result'); 
    resultDiv.innerHTML = message;
    
});

// 마커가 표시될 위치입니다 
/*var markerPosition1  = new kakao.maps.LatLng( 35.149780435451, 126.91993932993827); 
var markerPosition2  = new kakao.maps.LatLng( 35.15000878659675, 126.92109416021465); 
var markerPosition3  = new kakao.maps.LatLng( 35.14896088582207, 126.91760536236109); */
// 마커를 생성합니다
// 마커를 표시할 위치와 title 객체 배열입니다 
var positions = [
    {
        title: '카카오', 
		des:'설명',
        latlng: new kakao.maps.LatLng(35.149780435451, 126.91993932993827)
    },
    {
        title: '생태연못', 
   		des:'설명',
        latlng: new kakao.maps.LatLng(35.15000878659675, 126.92109416021465)
    },
    {
        title: '텃밭', 
	    des:'설명',
        latlng: new kakao.maps.LatLng(35.14896088582207, 126.91760536236109)
    }
];

// 마커 이미지의 이미지 주소입니다
var imageSrc = "https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/markerStar.png"; 
    
for (var i = 0; i < positions.length; i ++) {
    
    // 마커 이미지의 이미지 크기 입니다
    var imageSize = new kakao.maps.Size(24, 35); 
    
    // 마커 이미지를 생성합니다    
    var markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize); 
    
    // 마커를 생성합니다
    var marker = new kakao.maps.Marker({
        map: map, // 마커를 표시할 지도
        position: positions[i].latlng, // 마커를 표시할 위치
        title : positions[i].title, // 마커의 타이틀, 마커에 마우스를 올리면 타이틀이 표시됩니다
        image : markerImage // 마커 이미지 
    });

    // 마커에 표시할 인포윈도우를 생성합니다 
    var infowindow = new kakao.maps.InfoWindow({
        content: positions[i].title // 인포윈도우에 표시할 내용
    });

    // 마커에 mouseover 이벤트와 mouseout 이벤트를 등록합니다
    // 이벤트 리스너로는 클로저를 만들어 등록합니다 
    // for문에서 클로저를 만들어 주지 않으면 마지막 마커에만 이벤트가 등록됩니다
    kakao.maps.event.addListener(marker, 'click', makeOverListener(map, marker, infowindow));
 	 kakao.maps.event.addListener(marker, 'click', divchan(positions[i].title));
    kakao.maps.event.addListener(marker, 'mouseout', makeOutListener(infowindow));
}

function divchan(title) {
	
	    return function() {
       var rsname=document.getElementById('rsname');
	rsname.innerHTML=title;
    };


}

// 인포윈도우를 표시하는 클로저를 만드는 함수입니다 
function makeOverListener(map, marker, infowindow) {
    return function() {
        infowindow.open(map, marker);
    };
}

// 인포윈도우를 닫는 클로저를 만드는 함수입니다 
function makeOutListener(infowindow) {
    return function() {
        infowindow.close();
    };
}

// 마커가 지도 위에 표시되도록 설정합니다
marker.setMap(map);

// 아래 코드는 지도 위의 마커를 제거하는 코드입니다
// marker.setMap(null); 