function  saveData(){
    //get the data from text boxes to varibles(id,name,address,number)
    var id=$('#exampleFormControlInput1').val();
    var name=$('#exampleFormControlInput2').val();
    var address=$('#exampleFormControlInput3').val();
    var number=$('#exampleFormControlInput4').val();

    //recived data to the back-end suing ajax
    $.ajax({

    method: "POST",  //set the mapping method
    contentType: "application/json",  //define the recived content type
    url: "http://localhost:8080/api/v1/Controller/saveById", //difine the url
    async: true,   //enable async

    //difine json body
    data: JSON.stringify({
        "empId": id,
        "empName": name,
        "empAddress": address,
        "empMobileNumber": number
    }),

     //difine alerts
    success: function (data) {
        if(data.code==="00") {
            alert(data.massage)
            getAllData()

        }else{
            alert(data.massage)
        }
    }

})

}

function  updateData(){

    var id=$('#exampleFormControlInput1').val();
    var name=$('#exampleFormControlInput2').val();
    var address=$('#exampleFormControlInput3').val();
    var number=$('#exampleFormControlInput4').val();


    $.ajax({

        method: "PUT",
        contentType: "application/json",
        url: "http://localhost:8080/api/v1/Controller/updateById",
        async: true,
        data: JSON.stringify({
            "empId": id,
            "empName": name,
            "empAddress": address,
            "empMobileNumber": number
        }),
        success: function (data) {
            if(data.code==="00") {
                alert(data.massage)
                getAllData()

            }else{
                alert(data.massage)
            }
        }


    })

}

function  deleteData(){

    var id=$('#exampleFormControlInput1').val();

   //in the delete function won't to define contenttype(json) cause we only take empId not whole data
    //and also not use data :JSON section cause same as it's only take id not whole data therfore wo won't to convert our data to the json body
   //we can only refer id like follows
    $.ajax({

        method: "DELETE",

        url: "http://localhost:8080/api/v1/Controller/deleteDataById/"+id,
        async: true,

        success: function (data) {
            if(data.code==="00") {
                alert(data.massage)
                getAllData()

            }else{
                alert(data.massage)
            }
        }


    })

}

//method for get the all the data from the database emp table the data come as response entity and it's fethch in the succsess method
function  getAllData(){


    $.ajax({

        method: "GET",
        url: "http://localhost:8080/api/v1/Controller/getAllData",
        async: true,

        success: function (data) {
           if(data.code==="00"){
               $("#empTable").empty();
                    for(let emp of data.content){
                        let id=emp.empId
                        let name=emp.empName
                        let address=emp.empAddress
                        let number=emp.empMobileNumber

                        let row='<tr><td>'+id+'</td><td>'+name+'</td><td>'+address+'</td><td>'+number+'</td></tr>';
                       $("#empTable").append(row);
                    }
           }
        },
        error: function (xhr, exception) {
            alert("table is not updated")
        }

    })
}
//<--button type="button" class="btn btn-dark"  onclick="getAllData()">GetAll</button>