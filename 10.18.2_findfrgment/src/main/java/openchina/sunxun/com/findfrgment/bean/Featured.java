package openchina.sunxun.com.findfrgment.bean;
/**
 * Created by Administrator on 2016/10/19.
 */
public class Featured {

    private int id;
    private String name;
    private String description;
    private String default_branch;
    private Owner owner;
    private boolean publicx;
    private String path;
    private String path_with_namespace;
    private boolean issues_enabled;
    private boolean pull_requests_enabled;
    private boolean wiki_enabled;
    private String created_at;
    private Namespace namespace;
    private String last_push_at;
    private String parent_id;
    private boolean fork;
    private int forks_count;
    private int stars_count;
    private int watches_count;
    private String language;
    private String paas;
    private String stared;
    private String watched;
    private String relation;
    private int recomm;
    private String parent_path_with_namespace;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDefault_branch() {
        return default_branch;
    }

    public void setDefault_branch(String default_branch) {
        this.default_branch = default_branch;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public boolean isPublicx() {
        return publicx;
    }

    public void setPublicx(boolean publicx) {
        this.publicx = publicx;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getPath_with_namespace() {
        return path_with_namespace;
    }

    public void setPath_with_namespace(String path_with_namespace) {
        this.path_with_namespace = path_with_namespace;
    }

    public boolean issues_enabled() {
        return issues_enabled;
    }

    public void setIssues_enabled(boolean issues_enabled) {
        this.issues_enabled = issues_enabled;
    }

    public boolean isPull_requests_enabled() {
        return pull_requests_enabled;
    }

    public void setPull_requests_enabled(boolean pull_requests_enabled) {
        this.pull_requests_enabled = pull_requests_enabled;
    }

    public boolean isWiki_enabled() {
        return wiki_enabled;
    }

    public void setWiki_enabled(boolean wiki_enabled) {
        this.wiki_enabled = wiki_enabled;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public Namespace getNamespace() {
        return namespace;
    }

    public void setNamespace(Namespace namespace) {
        this.namespace = namespace;
    }

    public String getLast_push_at() {
        return last_push_at;
    }

    public void setLast_push_at(String last_push_at) {
        this.last_push_at = last_push_at;
    }

    public String getParent_id() {
        return parent_id;
    }

    public void setParent_id(String parent_id) {
        this.parent_id = parent_id;
    }

    public boolean isFork() {
        return fork;
    }

    public void setFork(boolean fork) {
        this.fork = fork;
    }

    public int getForks_count() {
        return forks_count;
    }

    public void setForks_count(int forks_count) {
        this.forks_count = forks_count;
    }

    public int getStars_count() {
        return stars_count;
    }

    public void setStars_count(int stars_count) {
        this.stars_count = stars_count;
    }

    public int getWatches_count() {
        return watches_count;
    }

    public void setWatches_count(int watches_count) {
        this.watches_count = watches_count;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getPaas() {
        return paas;
    }

    public void setPaas(String paas) {
        this.paas = paas;
    }

    public String getStared() {
        return stared;
    }

    public void setStared(String stared) {
        this.stared = stared;
    }

    public String getWatched() {
        return watched;
    }

    public void setWatched(String watched) {
        this.watched = watched;
    }

    public String getRelation() {
        return relation;
    }

    public void setRelation(String relation) {
        this.relation = relation;
    }

    public int getRecomm() {
        return recomm;
    }

    public void setRecomm(int recomm) {
        this.recomm = recomm;
    }

    public String getParent_path_with_namespace() {
        return parent_path_with_namespace;
    }

    public void setParent_path_with_namespace(String parent_path_with_namespace) {
        this.parent_path_with_namespace = parent_path_with_namespace;
    }

    @Override
    public String toString() {
        return "Featured{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", default_branch='" + default_branch + '\'' +
                ", owner=" + owner +
                ", publicx=" + publicx +
                ", path='" + path + '\'' +
                ", path_with_namespace='" + path_with_namespace + '\'' +
                ", issues_enabled=" + issues_enabled +
                ", pull_requests_enabled=" + pull_requests_enabled +
                ", wiki_enabled=" + wiki_enabled +
                ", created_at='" + created_at + '\'' +
                ", namespace=" + namespace +
                ", last_push_at='" + last_push_at + '\'' +
                ", parent_id='" + parent_id + '\'' +
                ", fork=" + fork +
                ", forks_count=" + forks_count +
                ", stars_count=" + stars_count +
                ", watches_count=" + watches_count +
                ", language='" + language + '\'' +
                ", paas='" + paas + '\'' +
                ", stared='" + stared + '\'' +
                ", watched='" + watched + '\'' +
                ", relation='" + relation + '\'' +
                ", recomm=" + recomm +
                ", parent_path_with_namespace='" + parent_path_with_namespace + '\'' +
                '}';
    }
}
