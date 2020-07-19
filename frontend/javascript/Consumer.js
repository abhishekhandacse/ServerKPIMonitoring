function netstat(){
  let req = new Request('http://localhost:8080/netstat',{method: 'GET'});
  fetch(req)
  .then(response => response.json()).then( response => document.getElementById('showoutput').innerHTML=response.body  ) ;
}

function ifconfig(){
  let req = new Request('http://localhost:8080/ifconfig',{method: 'GET'});
  fetch(req)
  .then(response => response.json()).then( response => document.getElementById('showoutput').innerHTML=response.body  ) ;
}

function lscpu(){
  let req = new Request('http://localhost:8080/lscpu',{method: 'GET'});
  fetch(req)
  .then(response => response.json()).then( response => document.getElementById('showoutput').innerHTML=response.body  ) ;
}

function lshw(){
  let req = new Request('http://localhost:8080/lshw',{method: 'GET'});
  fetch(req)
  .then(response => response.json()).then( response => document.getElementById('showoutput').innerHTML=response.body  ) ;
}
//


// function ifconfig(){
//   fetch('http://localhost:8080/ifconfig')
//  .then(data => console.log(data));
// }

// function lscpu(){
//   fetch('http://localhost:8080/lscpu')
//  .then(data => console.log(data));
// }

// function lshw(){
//   fetch('http://localhost:8080/lshw')
//  .then(data => console.log(data));
// }


