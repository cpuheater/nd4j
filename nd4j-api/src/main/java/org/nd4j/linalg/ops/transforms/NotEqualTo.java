package org.nd4j.linalg.ops.transforms;


import org.nd4j.linalg.api.complex.IComplexNumber;
import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.factory.Nd4j;
import org.nd4j.linalg.ops.BaseElementWiseOp;

/**
 * Not Equal to operator
 * @author Adam Gibson
 */
public class NotEqualTo extends BaseElementWiseOp {
    /**
     * The transformation for a given value (a scalar ndarray)
     *
     * @param value the value to applyTransformToOrigin (a scalar ndarray)
     * @param i     the index of the element being acted upon
     * @return the transformed value based on the input
     */
    @Override
    public Object apply(INDArray from,Object value, int i) {
        Object curr = getFromOrigin(from,i);
        double originValue = (Double) (curr instanceof IComplexNumber ? ((IComplexNumber) curr).absoluteValue() : (double) curr);
        double otherValue = (Double) (value instanceof IComplexNumber ? ((IComplexNumber) value).absoluteValue() : (double) value);
        if(originValue != otherValue) {
            if(value instanceof IComplexNumber) {
               return Nd4j.createDouble(1, 0);
            }
            else
                return (double) 1;


        }
        else {
            if(value instanceof IComplexNumber)
                return  Nd4j.createDouble(0, 0);

            else
                return (double) 0;


        }
    }
}
