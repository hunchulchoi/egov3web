<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>ARIA Test</title>

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>

    <div class="container">
        <h2>ARIA Test</h2>

        <div class="row w-50 mt-2">
            <label for="plain_text">평문</label>
            <input type="text" name="plainText" id="plain_text">
        </div>
        <div class="row w-50">
            <label for="encrypted_text">암호문</label>
            <input type="text" name="encryptedText" id="encrypted_text">
        </div>
        <div class="row w-50">
            <button class="btn btn-primary">전송</button>
        </div>

    </div>

</body>
<script>
    window.onload = (ev)=>{
      document.querySelector(".btn-primary").addEventListener('click', ()=>{
        const xhr = new XMLHttpRequest();

        xhr.onreadystatechange = ()=>{
          if(xhr.readyState === XMLHttpRequest.DONE){
            if(xhr.status === 200){
              const result = xhr.response;
              console.log(result);
              alert(result);
            }else{
              alert('Error' + xhr.status);
            }
          }
        };

        xhr.open('POST', '/study/aria_encrypt.do');

        xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
        xhr.send('plainText='+document.querySelector('#plain_text').value)
      })
    }
</script>
</html>