import './App.css';
import {useEffect, useState} from "react";
import axios from "axios";

function App() {
  const [ memberInput, setMemberInput] = useState({
    id:"",
    pw:"",
    name:""
  });

  const handlerMemberInputChange = (e) => {
    setMemberInput({
      ...memberInput,
      [e.target.name]: e.target.value
    });
  }

  useEffect(() => {
    axios.get("http://localhost:8000/api/hello")
      .then(response => setHello(response.data))
      .catch(error => console.log(error));
  }, []);
  return (
    <div className="App">
      백엔드 데이터 : {hello}
      <div>
        <input type="text" name="id" value={memberInput.id} onChange={handlerMemberInputChange} />
        <div>
          <button>회원가입</button>
          <div>
            <input type="text" name="pw" value={memberInput.pw} onChange={handlerMemberInputChange} />
            <div>
              <button>로그인</button>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
}

export default App;
