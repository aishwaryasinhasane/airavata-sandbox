/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

$(document).ready(function(){

    $('[name="btn2"]').click(function(){

        $.ajax({
            beforeSend: function(x) {
                if (x && x.overrideMimeType) {
                    x.overrideMimeType("application/j-son;charset=UTF-8");
                }
            },
            type: "GET",
            dataType: "json",
            contentType: "application/json;charset=utf-8",
            url: "http://localhost:7080/airavata-registry-rest-services/registry/api/get/hostdescriptors",
            success: function(data, status, settings) {
                var keys=[],result='';
                $.each(data.hostDescriptions,function(i,row){
                    $.each(row,function(key,value){
                        if ($.inArray(key,keys)==-1) keys.push(key);
                    })
                });
                result+="<thead><tr>";
                $.each(keys,function(i,key){
                    result+="<th>"+key+"<\/th>";
                });
                result+="<\/tr><\/thead><tbody>";
                $.each(data.hostDescriptions,function(i,row){
                    result+="<tr>";
                    $.each(keys,function(i,key){
                        result+="<td>"+ (row[key]||'') + "<\/td>";
                    });
                    result+="<\/tr>";
                });
                result+="<\/tbody>";
                $('#display').html(result);

            },
            error: function(ajaxrequest, ajaxOptions, thrownError){
                alert(thrownError);
            }

        });/*.done(function(msg) {
         alert( "Data Saved: " + JSON.stringify(msg));
         });*/

    });
});