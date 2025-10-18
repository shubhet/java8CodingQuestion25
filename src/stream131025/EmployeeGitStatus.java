package stream131025;


public class EmployeeGitStatus {
    long id;
    String name;
    long codeCommit;
    String dept;

    public EmployeeGitStatus(String name, long age, long codeCommit, String dept) {
        this.name = name;
        this.id = age;
        this.codeCommit = codeCommit;
        this.dept = dept;
    }
    public String getDept() {
        return dept;
    }
    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getName() {
        return name;
    }
    public long getId() {
        return id;
    }
    public long getCodeCommit() {
        return codeCommit;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setId(long id) {
        this.id = id;
    }
    public void setCodeCommit(long codeCommit) {
        this.codeCommit = codeCommit;
    }

    public String toString() {
        return "Employee{name=" + name + ", id=" + id + ", codeCommit=" + codeCommit + ", dept=" + dept + "}";
    }

    public EmployeeGitStatus(){
        super();
    }


}
