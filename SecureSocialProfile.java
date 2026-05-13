public class SecureSocialProfile {
    private String username;
    private String password;
    private int followersCount;
    private boolean isPrivate;

    public SecureSocialProfile(String name, String pass) {
        this.username = name;
        this.password = pass;
        this.followersCount = 0;
        this.isPrivate = true;
    }

    public String getUsername() {
        return username;
    }

    public int getFollowersCount() {
        return followersCount;
    }

    public void updatePassword(String oldPass, String newPass) {
        if (this.password.equals(oldPass) && newPass.length() >= 6) {
            this.password = newPass;
            System.out.println("Password updated.");
        } else {
            System.out.println("Password update failed.");
        }
    }

    public void addFollower() {
        this.followersCount++;
    }

    public static void main(String[] args) {
        SecureSocialProfile myProfile = new SecureSocialProfile("java_pro", "secure123");

        myProfile.updatePassword("wrong_pass", "hacked!");
        myProfile.updatePassword("secure123", "new_strong_pass");
        myProfile.addFollower();

        System.out.println("Followers: " + myProfile.getFollowersCount());
        System.out.println("Username: " + myProfile.getUsername());
    }
}
