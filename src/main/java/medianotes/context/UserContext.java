package medianotes.context;

public class UserContext {

    private static String userLogin = null;

    //Lombok не поддерживает работу со статическими методами
    //поэтому геттеры и сеттеры нужно прописать самостоятельно

    public static String getUserLogin() {
        return userLogin;
    }

    public static void setUserLogin(String userLogin){
        //this не прокатит, так как статический контекст
        UserContext.userLogin = userLogin;
    }

}
