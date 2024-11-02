const name = prompt("Hello! :) What is your name?");
//const link = document.getElementById('myLink');
//const channel = document.getElementById('channel1');
const dropdown = document.getElementById('channelSelected');

dropdown.addEventListener('change', function() {
  const selectedValue = dropdown.value;  
  console.log(selectedValue); // Do something with the selected value

  const data = { name: name };

    fetch('http://localhost:8080/channels/' + selectedValue, {
           method: 'POST',
           headers: {
               'Content-Type': 'application/json',
           },
           body: JSON.stringify(data),

       })
       .then(response => {
           if (response.redirected) {
               window.location.href = response.url;
           } else {
               console.error('Unexpected response:', response);
           }
       })
       .catch(error => {
           console.error('Error:', error);
       });
});

//channel.addEventListener('click', function()  
// {
//   const channelName = this.value;
//   console.log("Received value:" + channelName);
//
//   const data = { name: name };
//
//       fetch('http://localhost:8080/channels/' + channelName, {
//           method: 'POST',
//           headers: {
//               'Content-Type': 'application/json',
//           },
//           body: JSON.stringify(data),
//       })
//       .then(response => {
//           if (response.redirected) {
//               window.location.href = response.url;
//           } else {
//               console.error('Unexpected response:', response);
//           }
//       })
//       .catch(error => {
//           console.error('Error:', error);
//       });
//
//});

//link.addEventListener("click", () => {
//    event.preventDefault(); // Prevent default link behavior
//    submitUser();
//});
