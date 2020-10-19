package be.frituurfrida.frituurfrida.exceptions;

public class SausRepositoryException  extends RuntimeException{
    private Long serialVersionUID = 1L;
    public SausRepositoryException(String om){
        super(om);
    }
}
