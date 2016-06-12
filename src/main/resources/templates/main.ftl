<!DOCTYPE HTML>
<html>
    <head> 
        <title>Mimic Flickr</title> 
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <link rel="stylesheet" type="text/css" media="all" href="css/font-awesome.min.css" />
        <link rel="stylesheet" type="text/css" media="all" href="css/jgallery.min.css?v=1.5.5" />
        <link rel="stylesheet" type="text/css" media="all" href="css/bootstrap.min.css" />
         <link rel="stylesheet" type="text/css" media="all" href="css/mycss.css" />

        <script type="text/javascript" src="js/jquery-2.0.3.min.js"></script>
        <script type="text/javascript" src="js/jgallery.min.js?v=1.5.5"></script>
        <script type="text/javascript" src="js/touchswipe.min.js"></script>
        <script type="text/javascript" src="js/bootstrap.min.js"></script>
        <script type="text/javascript" src="js/mflickr.js"></script>
    </head>
    <body>
        <nav class="navbar">
            <button type="button" class="btn btn-default pull-left" data-toggle="modal" data-target="#addImage"><span class="glyphicon glyphicon-plus-sign" aria-hidden="true"></span></button>
            <button type="button" class="btn btn-default pull-right" data-toggle="modal" data-target="#searchImage"><span class="glyphicon glyphicon-search" aria-hidden="true"></span></button>
        </nav>	

        <div class="modal fade" id="addImage" role="dialog">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                        <h4 class="modal-title">Upload Image</h4>
                    </div>
                    <div class="modal-body">
                        <form id="addImage-form" class="simple_form form-horizontal" name="image">

                            <div class="form-group">
                                <label class="col-sm-3">Name</label>
                                <input class="col-sm-8" type="text" name="name"/>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3">Description</label>
                                <textarea class="col-sm-8" name="description"></textarea>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3">File</label>
                                <input class="col-sm-8" type="file" name="file" accept="image/*"/>
                            </div>
                                <button id="addImage-btn" type="submit" class="btn btn-default" data-dismiss="modal">Save</button>
                        </form>
                    </div>

                </div>
            </div>
        </div>
        <div class="modal fade" id="searchImage" role="dialog">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                        <h4 class="modal-title">Search Images</h4>
                    </div>
                    <div class="modal-body">
                        <form id="searchImage-form" class="simple_form form-horizontal" action="/images" method="post">

                            <div class="form-group">
                                <label class="col-sm-3">Name contains</label>
                                <input id="searchImage-name" class="col-sm-8" type="text" name="name"/>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3">Description contains</label>
                                <input id = "searchImage-description" class="col-sm-8" name="description"/>
                            </div>
                        </form>
                    </div>
                    <div class="modal-footer">
                         <button id="searchImage-clbtn" type="button" class="btn btn-default" data-dismiss="modal">Clean</button>
                        <button id="searchImage-btn" type="button" class="btn btn-default" data-dismiss="modal">Find</button>
                    </div>
                </div>
            </div>
        </div>
       <div class="container">
            <div id="gallery">
            </div>
        </div>	
    </body>
</html>