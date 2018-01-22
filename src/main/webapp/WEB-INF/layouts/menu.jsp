<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 17.01.2018
  Time: 21:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<aside class="main-sidebar">

    <!-- sidebar: style can be found in sidebar.less -->
    <section class="sidebar">

        <!-- Sidebar user panel (optional) -->
        <div class="user-panel">
            <div class="pull-left image">
                <img src="${resources}/dist/img/user2-160x160.jpg" class="img-circle" alt="User Image">
            </div>
            <div class="pull-left info">
                <p>Vusal Rzayev</p>
                <!-- Status -->
                <a href="#"><i class="fa fa-circle text-success"></i> Online</a>
            </div>
        </div>

        <!-- search form (Optional) -->
        <form action="#" method="get" class="sidebar-form">
            <div class="input-group">
                <input type="text" name="q" class="form-control" placeholder="Search...">
                <span class="input-group-btn">
              <button type="submit" name="search" id="search-btn" class="btn btn-flat"><i class="fa fa-search"></i>
              </button>
            </span>
            </div>
        </form>
        <!-- /.search form -->

        <!-- Sidebar Menu -->
        <ul class="sidebar-menu" data-widget="tree">
            <li class="header">MENU</li>
            <!-- Optionally, you can add icons to the links -->
            <li class="treeview " id="studentTreeView">
                <a href="#"><i class="fa fa-graduation-cap"></i> <span>Student</span>
                    <span class="pull-right-container">
                <i class="fa fa-angle-left pull-right"></i>
              </span>
                </a>
                <ul class="treeview-menu">
                    <li><a href="studentList">   Student List</a></li>
                    <li><a href="add_new_student">   Add New Student</a></li>
                </ul>
            </li>
            <li class="treeview " id="teacherTreeView">
                <a href="#"><i class="fa fa-user"></i> <span>Teacher</span>
                    <span class="pull-right-container">
                <i class="fa fa-angle-left pull-right"></i>
              </span>
                </a>
                <ul class="treeview-menu active">
                    <li><a href="#">   Teacher List</a></li>
                    <li><a href="#">   Add New Teacher</a></li>
                </ul>
            </li>
            <li class="treeview " id="lessonTreeView">
                <a href="#"><i class="fa fa-book"></i> <span>Lesson</span>
                    <span class="pull-right-container">
                <i class="fa fa-angle-left pull-right"></i>
              </span>
                </a>
                <ul class="treeview-menu active">
                    <li><a href="#">   Lesson List</a></li>
                    <li><a href="#">   Add New Lesson</a></li>
                </ul>
            </li>
        </ul>
        <!-- /.sidebar-menu -->
    </section>
    <!-- /.sidebar -->
</aside>
