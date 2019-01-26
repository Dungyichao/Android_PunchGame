// Initialize Firebase
        var config = {
    apiKey: "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA",
    authDomain: "ABC.firebaseapp.com",
    databaseURL: "https://ABC.firebaseio.com",
    projectId: "ABC",
	storageBucket: "ABC.appspot.com",
	messagingSenderId: "156516516"
  };
        firebase.initializeApp(config);


        var database = firebase.database();
        database.ref().child("Score").once('value', function (snapshot) {
            if (snapshot.exists()) {
                var content = '';
                snapshot.forEach(function (data) {
                    var val = data.val();
                    //var name, score, keyval;
                     
             
                    content += '<tr>';
                    content += '<td>' + val.username + '</td>';
                    content += '<td>' + val.playscore + '</td>';
                    content += '</tr>';
                });
                $('#ex-table').append(content);
            }
        });