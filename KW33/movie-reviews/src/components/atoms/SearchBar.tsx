import { useState } from "react";
import { TextField } from "@mui/material";

function SearchBar() {
  const [inputText, setInputText] = useState("");

  const inputHandler = (e: React.ChangeEvent<HTMLInputElement>) => {
    const lowerCase = e.target.value.toLowerCase();
    setInputText(lowerCase);
  };

  return (
    <div className="main">
      <h1>React Search</h1>
      <div className="search">
        <TextField
          id="outlined-basic"
          variant="outlined"
          fullWidth
          label="Search"
          onChange={inputHandler}
        />
      </div>
      {/*braucht daten*/}
    </div>
  );
}

export default SearchBar;
