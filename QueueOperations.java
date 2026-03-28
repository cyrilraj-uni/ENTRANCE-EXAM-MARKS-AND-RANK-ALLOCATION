package project_files;
public class QueueOperations {
    QuNode front = null;
    QuNode rear = null;
    QuNode lastStored;
    
    public void TopRankers(Nodey head) {
        front = null;
        rear = null;
        Nodey temp = head;
        
        while (temp != null) {
            QuNode Qn = new QuNode(temp.marks);
            if (rear == null) {
                rear = front = Qn;
            } else if (Qn.marks > front.marks) {
                Qn.link = front;
                front = Qn;
            } else {
                QuNode t = front;
                while (t.link != null && t.link.marks >= Qn.marks) {
                    t = t.link;
                }
                Qn.link = t.link;
                t.link = Qn;
            }
            if (Qn.link == null) {
                rear = Qn;
            }
            temp = temp.link;
        }
        
        QuNode curr = front;
        int rank = 1;
        
        while (curr != null && rank <= 20) {
            curr.rank = rank;
            if (rank == 1) {
                curr.Sc = 90;
            } else if (rank >= 2 && rank <= 5) {
                curr.Sc = 75;
            } else if (rank >= 6 && rank <= 15) {
                curr.Sc = 60;
            } else {
                curr.Sc = 50;
            }
            System.out.println("HT :"+curr.Ht+"Rank: " + curr.rank + " Marks: " + curr.marks + 
                             " Scholarship: " + curr.Sc + "%");
            lastStored = curr.link;
            curr = curr.link;
            rank++;
        }
    }
    
    public void otherRank(int totalCount) {
        QuNode cur = lastStored;
        if (totalCount <= 20) {
            System.out.println("ONLY " + totalCount + " Student's data is available!");
            return;
        }
        int rank = 21;
        while (cur != null) {
            cur.rank = rank;
            System.out.println("Rank: " + cur.rank + " Marks: " + cur.marks);
            cur = cur.link;
            rank++;
        }
    }
}