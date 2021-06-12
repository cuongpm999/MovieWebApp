$(document).ready(function () {
    // jquery cho onTop
    $(document).scroll(function () {
        if ($(document).scrollTop() != 0) {
            $("#onTop").fadeIn();
        } else {
            $("#onTop").fadeOut();
        }
    });
    $("#onTop").click(function () {
        $("html, body").animate({ scrollTop: 0 }, 700);
    });
    
    $("#summernote").summernote({
		placeholder : 'Nội dung chi tiết',
		tabsize : 2,
		height : 100
	});
	
	$("#myInput").on("keyup", function() {
    	var value = $(this).val().toLowerCase();
   		$("#myTable tr").filter(function() {
      		$(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
    	});
  	});

    // jquery cho sticky scroll
    $('#waypoint_here').waypoint(function(direction){
        if(direction == "down"){
            $('.head-nav').addClass('fixed-top');
        }else{
            $('.head-nav').removeClass('fixed-top');
        }
    }, {
        offset: '700px'
    })
   
});


var Blog = {

	displayPhimBo : function(name){	
		var video=document.getElementById('videoId');
		console.log(name);
		video.src="https://drive.google.com/file/d/"+name+"/preview";
		video.load();
	},
		
	deleteForm : function(modalID, entityId, restApi) {
		$("#deleteOk").click(function() {

			var data = {};
			data["entityId"] = entityId;
			$.ajax({
				url : restApi,
				type : "post",
				contentType : "application/json", // dữ liệu gửi lên
														// RestAPI
					// có dạng là json.
				data : JSON.stringify(data), // object json -> string
													// json

				dataType : "json", // dữ liệu từ Rest trả về là json.
				success : function(jsonResult) { 
														
					if (jsonResult.status == "69") {
						window.location.reload();
					} 
				}
			});

		});
		$('#' + modalID).modal('show');
	},
		
	goNext(url) {
		var tech = Blog.getUrlParameter('page');
		window.location = url + "?page=" + (parseInt(tech) + 1);
	},
		
	getUrlParameter : function(sParam) {
		var sPageURL = window.location.search.substring(1),
	    sURLVariables = sPageURL.split('&'),
	    sParameterName,
	    i;

		for (i = 0; i < sURLVariables.length; i++) {
			sParameterName = sURLVariables[i].split('=');

			if (sParameterName[0] === sParam) {
				return sParameterName[1] === undefined ? true : decodeURIComponent(sParameterName[1]);
			}
		}
	},
		
	goPrev(url) {
		var tech = Blog.getUrlParameter('page');
		if(parseInt(tech)>1)
			window.location = url + "?page=" + (parseInt(tech) - 1);
			
	},
		

}