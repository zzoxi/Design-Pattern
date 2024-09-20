package code;

import java.util.Optional;

class UserInfoDTO {
    private int userId;
    public int getUserId() {
        return userId;
    }
}
public class StreamTest {
    public static void main(String[] args) {
        UserInfoDTO userInfoDTO = null;
        Optional.ofNullable(userInfoDTO).map(UserInfoDTO::getUserId).orElse(null);
    }
}
