package project_files;
class HashGateKeep{
    int size;
    Nodey[] hashtable;
    
    HashGateKeep(int size){
        this.size = size;
        hashtable = new Nodey[size];
    }
    
    public int DivMethod(long ht){
        int unq = (int)(ht % 1000);
        return unq % size;
    }
    
    public void Insert(Nodey student) {
        int index = DivMethod(student.Ht);
        if(hashtable[index] == null) {
            hashtable[index] = student;
            student.link = null;
        } else {
            Nodey temp = hashtable[index];
            while(temp.link != null) {
                temp = temp.link;
            }
            temp.link = student;
            student.link = null;
        }
    }
    
    public boolean IsExist(long ht){
        int index = DivMethod(ht);
        Nodey current = hashtable[index];
        while(current != null) {
            if(current.Ht == ht) {
                return true;
            }
            current = current.link;
        }
        return false;
    }
}