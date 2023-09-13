/*
function initMap() { 

    
    const buttonTheatromunicipal = document.querySelector("#theatromunicipal");
    
    buttonTheatromunicipal.addEventListener("click", (e) => {
        const localizacao = { lat: -23.71124566216385, lng: -46.417362374476106 };
        console.log(localizacao);
    })
          
    const theatromunicipal = { lat: -23.545018395286316, lng: -46.6386150033158 };
    const museudoipiranga = { lat: -23.585106, lng: -46.610096 };
    const casadasrosas = { lat: -23.570532480566737, lng: -46.645110284659836 };
    const antigafabrica = { lat: -23.71124566216385, lng: -46.417362374476106 };
    const paranapiacaba = { lat:  -23.77831485811314, lng: -46.303032954383895 };
    const parquedoibirapuera = { lat: -23.588333, lng: -46.658890 };

    const map = new google.maps.Map(document.getElementById("map"), {
    center: paranapiacaba,
    zoom: 15,

  });

  */

function initMap() {

    const buttonTheatroMunicipal = document.querySelector("#theatromunicipal");
    const buttonMuseudoIpiranga = document.querySelector("#museudoipiranga");
    const buttonCasaDasRosas = document.querySelector("#casadasrosas");
    const buttonAntigaFabrica = document.querySelector("#antigafabrica");
    const buttonParanapiacaba = document.querySelector("#paranapiacaba");
    const buttonParqueDoIbirapuera = document.querySelector("#parquedoibirapuera");

    var localizacao = [
        ['Theatro Municipa', -23.545018395286316, -46.6386150033158],
        ['Museudo Ipiranga', -23.585106, -46.610096],
        ['Casa Das Rosas', -23.570532480566737, -46.645110284659836],
        ['Antiga Fabrica', -23.71124566216385, -46.417362374476106],
        ['Paranapiacaba', -23.77831485811314, -46.303032954383895],
        ['Parque Do Ibirapuera', -23.588333, -46.658890],
    ];

    var map = new google.maps.Map(document.getElementById("map"), {
        center: { lat: -23.5275, lng: -46.6784 },
        zoom: 15
    });

    buttonTheatroMunicipal.addEventListener("click", () => {
        var centro = localizacao[0];
        currentLatLong = new google.maps.LatLng(centro[1], centro[2]);

        map = new google.maps.Map(document.getElementById("map"), {
            center: currentLatLong,
            zoom: 15
        });

        marker = new google.maps.Marker({
            position: currentLatLong,
            map: map
        });
    });

    buttonMuseudoIpiranga.addEventListener("click", () => {
        var centro = localizacao[1];
        currentLatLong = new google.maps.LatLng(centro[1], centro[2]);

        map = new google.maps.Map(document.getElementById("map"), {
            center: currentLatLong,
            zoom: 15
        });

        marker = new google.maps.Marker({
            position: currentLatLong,
            map: map
        });
    });

    buttonCasaDasRosas.addEventListener("click", () => {
        var centro = localizacao[2];
        currentLatLong = new google.maps.LatLng(centro[1], centro[2]);

        map = new google.maps.Map(document.getElementById("map"), {
            center: currentLatLong,
            zoom: 15
        });

        marker = new google.maps.Marker({
            position: currentLatLong,
            map: map
        });
    });

    buttonAntigaFabrica.addEventListener("click", () => {
        var centro = localizacao[3];
        currentLatLong = new google.maps.LatLng(centro[1], centro[2]);

        map = new google.maps.Map(document.getElementById("map"), {
            center: currentLatLong,
            zoom: 15
        });

        marker = new google.maps.Marker({
            position: currentLatLong,
            map: map
        });
    });

    buttonParanapiacaba.addEventListener("click", () => {
        var centro = localizacao[4];
        currentLatLong = new google.maps.LatLng(centro[1], centro[2]);

        map = new google.maps.Map(document.getElementById("map"), {
            center: currentLatLong,
            zoom: 15
        });

        marker = new google.maps.Marker({
            position: currentLatLong,
            map: map
        });
    });

    buttonParqueDoIbirapuera.addEventListener("click", () => {
        var centro = localizacao[5];
        currentLatLong = new google.maps.LatLng(centro[1], centro[2]);

        map = new google.maps.Map(document.getElementById("map"), {
            center: currentLatLong,
            zoom: 15
        });

        marker = new google.maps.Marker({
            position: currentLatLong,
            map: map
        });
    });

    const request = {
        placeId: "ChIJN1t_tDeuEmsRUsoyG83frY4",
        fields: ["name", "formatted_address", "place_id", "geometry"],
    };
    const infowindow = new google.maps.InfoWindow();
    const service = new google.maps.places.PlacesService(map);

    service.getDetails(request, (place, status) => {
        if (
            status === google.maps.places.PlacesServiceStatus.OK &&
            place &&
            place.geometry &&
            place.geometry.location
        ) {

            var marker = new google.maps.Marker({
                position: { lat: -23.5275, lng: -46.6784 },
                map: map
            });

            google.maps.event.addListener(marker, "click", () => {
                const content = document.createElement("div");
                const nameElement = document.createElement("h2");

                nameElement.textContent = place.name;
                content.appendChild(nameElement);

                const placeIdElement = document.createElement("p");

                placeIdElement.textContent = place.place_id;
                content.appendChild(placeIdElement);

                const placeAddressElement = document.createElement("p");

                placeAddressElement.textContent = place.formatted_address;
                content.appendChild(placeAddressElement);
                infowindow.setContent(content);
                infowindow.open(map, marker);
            });
        }
    });
}

window.initMap = initMap;
