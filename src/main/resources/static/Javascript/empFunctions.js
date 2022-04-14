async function dispInfo() {
	
	let input = document.getElementById("userName").value;
	
	let response = await fetch(`users/${input}`);
	
	let userData = await response.json();
	
	console.log(userData);
	
	document.getElementById("userId").value = userData.id;
	
	document.getElementById("userFirst").value = userData.firstName;
	
	document.getElementById("userLast").value = userData.lastName;
	
	document.getElementById("username").value = userData.username;
	
	document.getElementById("pass").value = userData.password;
	
	document.getElementById("userEmail").value = userData.email;

}

async function empInfoById() {
	
	let input = document.getElementById("acctId").value;
	
	let response = await fetch(`/users/${input}/reimbursement`);
	
	let idRembList = await response.json();
	
	let idRembBody = document.getElementById("idRembBody");
	
	console.log(idRembList);

	for(let index = 0; index < idRembList.length; index++) {
		
		let element = idRembList[index];
		
		idRembBody.innerHTML +=
		`
		<tr>
      
        <td class = "text-center">${element.id}</td>
        <td class = "text-center">${element.amount}</td>
        <td class = "text-center">${element.description}</td>
        <td class = "text-center">${element.author}</td>
        <td class = "text-center">${element.submitted}</td>
        <td class = "text-center">${element.resolved}</td>
        <td class = "text-center">${element.resolver}</td>
        <td class = "text-center">${element.status}</td>
        <td class = "text-center">${element.type}</td>

        </tr>`;
}
}

async function postReimb() {
	
	let id = document.getElementById("Id").value;
	let amount = document.getElementById("amount").value;
	let description = document.getElementById("description").value;
	
	let req = {reimb_amount: amount, reimb_description: description, reimb_id: id};
	
	let response = await fetch(`/reimbursement`, {
		 method: "POST",
  		headers: {'Content-Type': 'application/json'}, 
  		body: JSON.stringify(req)
	});
	
	if(response.status !== 200) {
			
			//if login attempt fails
			alert("Failed to Update");
		}
		
		else {
			
			
			alert("Posted Successfully!") 
		}
		
	  console.log("Request Sent! response:", response);
}


async function updateInfo() {
	
	let id = document.getElementById("userId").value;
	
	let fname = document.getElementById("userFirst").value;
	
	let lname = document.getElementById("userLast").value;
	
	let username = document.getElementById("username").value;
	
	let pass = document.getElementById("pass").value;
	
	let email = document.getElementById("userEmail").value;
	
	let user = {id: id, firstName: fname, lastName: lname, username: username, password: pass, email: email, roleId: 1};
	
	console.log(user);
	
	let response = await fetch(`/users`, {
		 method: "PUT",
  		headers: {'Content-Type': 'application/json'}, 
  		body: JSON.stringify(user)
	});
	
	if(response.status !== 200) {
			
			//if login attempt fails
			alert("Failed to Update");
		}
		
		else {
			
			
			alert("Updated Successfully!") 
		}
		
	  console.log("Request complete! response:", response);
	
}