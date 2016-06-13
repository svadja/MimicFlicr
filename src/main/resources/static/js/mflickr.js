var imagesStore;
$(function () {
    getAllImage();
    $('#addImage-btn').click(function () {
        var formData = new FormData($('#addImage-form')[0]);
        $.ajax({
            url: "/images",
            type: "POST",
            data: formData,
            async: false,
            cache: false,
            contentType: false,
            processData: false,
            success: function () {
                getAllImage();
            },
            error: function (jXHR, textStatus, errorThrown) {
                alert(errorThrown);
            }
        });
    });

    $('#searchImage-btn').click(function () {
        $.get("/images", {
            name: $("#searchImage-name").val(),
            description: $("#searchImage-description").val()
        }, createGallary);

    });

    $('#searchImage-clbtn').click(function () {
         $("#searchImage-name").val("");
         $("#searchImage-description").val("");
        getAllImage();
    });
    
    function bindGallery() {
        $('#gallery').jGallery().destroy();
        $('#gallery').jGallery();
    }

    function createGallary(images) {
        imagesStore = images;
        var name;
        var description;
        var dateCreation;
        $('#gallery').empty();
        for (i = 0; i < images.length; i++) {
            if (images[i].name !== null) {
                name = images[i].name;
            } else {
                name = "";
            }
            ;
            if (images[i].description !== null) {
                description = images[i].description;
            } else {
                description = "";
            }
            if (images[i].dateCreation !== null) {
                dateCreation = new Date(images[i].dateCreation.epochSecond*1000);
            } else {
                dateCreation = "";
            }
            //Костиль
            var alt ="<div class= 'myfooter'><p class='pname'>" +name+ " (id:"+images[i].id+") </p><p class=pdescr>" + description + "</p><p class='pdate'>" + dateCreation+"</p></div>";
            $('#gallery').append('<a href="/store/' + images[i].filePath + '"><img src="/store/' + images[i].filePath + '" alt ="' + alt + '"></a>');
        }
        bindGallery();
    }

    function getAllImage() {
        $.get("/images", {
        }, createGallary);
    }

});

