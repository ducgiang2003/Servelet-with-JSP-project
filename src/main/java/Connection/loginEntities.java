package Connection;

public class loginEntities {
private String userName,passWord;

public String getUserName() {
	return userName;
}

public void setUserName(String userName) {
	this.userName = userName;
}

public String getPassWord() {
	return passWord;
}

public void setPassWord(String passWord) {
	this.passWord = passWord;
}

@Override
public String toString() {
	return "loginEntities [userName=" + userName + ", passWord=" + passWord + "]";
}


}
