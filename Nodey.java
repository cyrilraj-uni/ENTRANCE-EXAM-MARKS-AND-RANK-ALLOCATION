package project_files;
class Nodey{
    double marks;
    long Ht;
    String name;
    Nodey link;
    Nodey tail;
    
    Nodey(double marks, long ht, String name){
        this.marks = marks;
        this.Ht = ht;
        this.name = name;
        link = null;
    }
}