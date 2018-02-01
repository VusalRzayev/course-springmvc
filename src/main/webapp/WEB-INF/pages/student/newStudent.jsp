<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 17.01.2018
  Time: 21:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../../layouts/header.jsp"%>
<%@include file="../../layouts/menu.jsp"%>

<!-- Content Wrapper. Contains page content -->
<div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
        <h1>
            Content
            <small>New Student</small>
        </h1>
    </section>

    <!-- Main content -->
    <section class="content container-fluid">


            <div class="box-body">
                <div class="form-group">
                    <label for="studentNameId">Student Name</label>
                    <input type="text" class="form-control" id="studentNameId" placeholder="Enter Student Name" required>
                </div>
                <div class="form-group">
                    <label for="studentSurnameId">Student Surname</label>
                    <input type="text" class="form-control" id="studentSurnameId" placeholder="Enter Student Surname" required>
                </div>
                <h5>Student Email Address</h5>
                <div class="form-group">
                    <div class="input-group">
                        <span class="input-group-addon">
                        <i class="fa fa-envelope"></i>
                    </span>
                        <input type="email" class="form-control" id="studentEmailAddressId" placeholder="Enter email">
                    </div>

                </div>

                <div class="form-group">
                    <label>Student Birth Date</label>

                    <div class="input-group date">
                        <div class="input-group-addon">
                            <i class="fa fa-calendar"></i>
                        </div>
                        <input type="text" class="form-control pull-right" id="studentDobId" required>
                    </div>
                    <!-- /.input group -->
                </div>
                <div class="form-group">
                    <label>Select Teacher</label>
                    <select class="form-control" id="teacherComboId">
                        <option value="0">Select</option>
                        <c:forEach var="teacher" items="${teachers}">
                            <option value="${teacher.id}">${teacher.name} ${teacher.surname}----${teacher.lesson.name}</option>
                        </c:forEach>
                    </select>
                </div>

            </div>
            <!-- /.box-body -->

            <div class="box-footer">
                <button type="submit" class="btn btn-primary" id="studentAddBtn">Add Student</button>
            </div>


    </section>
    <!-- /.content -->
</div>
<!-- /.content-wrapper -->

<!-- Main Footer -->
<%@include file="../../layouts/footer.jsp"%>


