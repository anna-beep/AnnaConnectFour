public class Player {
    //this is the super class
    //"protected" means available to sub-classes but nowhere else
    protected String name;
    protected String token;


    public Player(String name, String token) {
        this.name = name;
        this.token = token;
    }

}
