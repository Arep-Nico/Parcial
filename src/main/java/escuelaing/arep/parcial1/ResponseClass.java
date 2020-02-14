package escuelaing.arep.parcial1;

import java.util.List;

/**
 * ResponseClass
 * 
 * @param <T>
 */
public class ResponseClass<T> {

    private Double sum;
    private List<T> list;

	public ResponseClass(Double sum, List<T> list) {
		this.sum = sum;
		this.list = list;
	}

    public Double getSum() {
        return sum;
    }

    public void setSum(Double sum) {
        this.sum = sum;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }
    
}