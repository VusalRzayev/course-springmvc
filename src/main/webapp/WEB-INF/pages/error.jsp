<%@include file="../layouts/header.jsp" %>
<%@include file="../layouts/menu.jsp" %>

    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>
                ${message} Error Page
            </h1>
        </section>

        <!-- Main content -->
        <section class="content">
            <div class="error-page">
                <h2 class="headline text-yellow"> ${title}</h2>

                <div class="error-content">
                    <h3><i class="fa fa-warning text-yellow"></i> ${message}</h3>


                <!-- /.error-content -->
            </div>
            <!-- /.error-page -->
        </section>
        <!-- /.content -->
    </div>
    <!-- /.content-wrapper -->

<%@include file="../layouts/footer.jsp" %>
