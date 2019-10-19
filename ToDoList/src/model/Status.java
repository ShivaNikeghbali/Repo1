package model;

public enum Status {
    Done,
    Not_Done;

    public static Status of(String status) {
        if (status.equalsIgnoreCase("done")){
            return Status.Done;
        } else if(status.equalsIgnoreCase("not_done")){
            return Status.Not_Done;
        } else{
            return null;
        }
    }
}
