<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
      <div class="box-body">
            <div class="form-group">
                <label for="studentNameId">Student Name</label>
                <input type="hidden" name="studentId" id="studentId" value="${student.id}">
                <input type="text" class="form-control" id="studentNameId" value="${student.name}" required>
            </div>
            <div class="form-group">
                <label for="studentSurnameId">Student Surname</label>
                <input type="text" class="form-control" id="studentSurnameId" value="${student.surname}" required>
            </div>
            <h5>Student Email Address</h5>
            <div class="form-group">
                <div class="input-group">
                        <span class="input-group-addon">
                        <i class="fa fa-envelope"></i>
                    </span>
                    <input type="email" class="form-control" id="studentEmailAddressId" value="${student.address}">
                </div>

            </div>

            <div class="form-group">
                <label>Select Teacher</label>
                <select class="form-control" id="teacherComboId">
                    <option value="${student.teacher.id}">${student.teacher.name}-----${student.teacher.lesson.name}</option>
                    <c:forEach var="teacher" items="${teachers}">
                        <c:if test="${student.teacher.id ne teacher.id}">
                            <option value="${teacher.id}">${teacher.name}------${teacher.lesson.name}</option>
                        </c:if>
                    </c:forEach>
                </select>
            </div>

        </div>
        <!-- /.box-body -->

    </section>
    <!-- /.content -->
</div>






