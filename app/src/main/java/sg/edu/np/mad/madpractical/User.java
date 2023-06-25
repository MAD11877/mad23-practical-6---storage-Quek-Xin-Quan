package sg.edu.np.mad.madpractical;

public class User {
    public String Name;
    public String Description;
    public Integer Id;
    public Boolean Followed;

    public User() {
    }

    public User(String name, String description, Integer id, Boolean followed) {
        Name = name;
        Description = description;
        Id = id;
        Followed = followed;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public Integer getId() {

        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public Boolean getFollowed() {
        return Followed;
    }

    public void setFollowed(Boolean followed) {
        Followed = followed;
    }
}
