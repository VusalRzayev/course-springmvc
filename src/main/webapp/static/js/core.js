var clickedMenu=null;
$(function () {
   clickedMenu = $(this).attr('title');
   setActiveTreeViewMenu();

    $('#studentDataTable').DataTable();
    $('#studentDobId').datepicker({
       autoclose:true
    });



    $('#resultModal').dialog({
       autoOpen:false,
        buttons:{
           "close":function () {
               $('#resultModal').dialog('close');
           }
        }
    });



});

function setActiveTreeViewMenu(){
    if(clickedMenu!=null){
        switch(clickedMenu){
            case 'Student List':
                $('#studentTreeView').addClass(' active');
                break;
            case 'New Student':
                $('#studentTreeView').addClass(' active');
                break;
            case 'Teacher List':
                $('#teacherTreeView').addClass(' active');
                break;
            case 'New Teacher':
                $('#teacherTreeView').addClass(' active');
                break;
            case 'Lesson List':
                $('#lessonTreeView').addClass(' active');
                break;
            case 'New Lesson':
                $('#lessonTreeView').addClass(' active');
                break;
        }
    }
}