$(function () {
   $('#studentAddBtn').click(function () {
       addStudent();
   });

   $('#editStudentBtn').click(function () {
      updateStudent();
   });



});

function addStudent(){
    var name=$('#studentNameId').val();
    var surname=$('#studentSurnameId').val();
    var dob=$('#studentDobId').val();
    var email=$('#studentEmailAddressId').val();
    var teacherId=$('#teacherComboId').val();

    var data={name:name,surname:surname,dob:dob,email:email,teacherId:teacherId};

    $.ajax({
        url:'addStudent',
        type:'post',
        dataType:'text',
        data:data,
        success:function (response) {
            $('#resultModal').html('<p>'+response+'</p>');
            $('#resultModal').dialog('open');
        }


    });

}


function editStudent(id){

    $.ajax({
        type: 'get',
        url: 'getStudentById/' + id,
        dataType: 'html',
        success:function (response) {
            $('#editStudentModalBody').html(response);
        }
    })};

function updateStudent(){
    var id=$('#studentId').val();
    var name=$('#studentNameId').val();
    var surname=$('#studentSurnameId').val();
    var email=$('#studentEmailAddressId').val();
    var teacherId=$('#teacherComboId').val();
    var data={id:id,name:name,surname:surname,email:email,teacherId:teacherId};

    $.ajax({
       data:data,
       type:'post',
       dataType:'html',
       url:'editStudent',
        success:function (response) {
        if(response=='Error'){

        }
        }
    });

}


function deleteStudent(id){
    $.ajax({
        type:'get',
        url:'deleteStudent/'+id,
        dataType:'html',
        success:function(response){
            $('#resultModal').html('<p>'+response+'</p>');
            $('#resultModal').dialog('open');
          
            
        }
        
    });
}