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
            <small>Student List</small>
        </h1>
    </section>

    <!-- Main content -->
    <section class="content container-fluid">

        <div class="box">
            <div class="box-header">
                <h3 class="box-title">Student Data Table</h3>
            </div>
            <!-- /.box-header -->
            <div class="box-body">
                <table id="studentDataTable" class="table table-bordered table-striped">
                    <thead>
                    <tr>
                        <th>Id</th>
                        <th>Student Name</th>
                        <th>Student Surname</th>
                        <th>Student Address</th>
                        <th>Student Birth Date</th>
                        <th>Student Teacher</th>
                        <th>Student Lesson</th>
                        <th>Edit</th>
                        <th>Delete</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="student" items="${students}">
                        <tr>
                            <td>${student.id}</td>
                            <td>${student.name}</td>
                            <td>${student.surname}</td>
                            <td>${student.address}</td>
                            <td>${student.dob}</td>
                            <td>${student.teacher.name} ${student.teacher.surname}</td>
                            <td>${student.teacher.lesson.name}</td>
                            <td><button class="btn btn-primary"  data-toggle="modal" data-target="#editStudentModal" onclick="editStudent(${student.id})">Edit</button></td>
                            <td><button class="btn btn-danger" onclick="deleteStudent(${student.id})">Delete</button></td>
                        </tr>
                    </c:forEach>


                    </tbody>
                </table>
            </div>
            <!-- /.box-body -->
        </div>

    </section>
    <!-- /.content -->
</div>
<!-- /.content-wrapper -->

<!-- Main Footer -->
<%@include file="../../layouts/footer.jsp"%>

