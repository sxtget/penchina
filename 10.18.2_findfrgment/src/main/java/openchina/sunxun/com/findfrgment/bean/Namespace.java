package openchina.sunxun.com.findfrgment.bean;

/**
 * Created by Administrator on 2016/10/19.
 */
public class Namespace {

    private String address;
    private String avatar;
    private String created_at;
    private String description;
    private String email;
    private int id;
    private String location;
    private String name;
    private int owner_id;
    private String path;
    private String publicx;
    private String updated_at;
    private String url;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getOwner_id() {
        return owner_id;
    }

    public void setOwner_id(int owner_id) {
        this.owner_id = owner_id;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getPublicx() {
        return publicx;
    }

    public void setPublicx(String publicx) {
        this.publicx = publicx;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Namespace{" +
                "address='" + address + '\'' +
                ", avatar='" + avatar + '\'' +
                ", created_at='" + created_at + '\'' +
                ", description='" + description + '\'' +
                ", email='" + email + '\'' +
                ", id=" + id +
                ", location='" + location + '\'' +
                ", name='" + name + '\'' +
                ", owner_id=" + owner_id +
                ", path='" + path + '\'' +
                ", publicx='" + publicx + '\'' +
                ", updated_at='" + updated_at + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
