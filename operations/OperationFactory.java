/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imageproc.operations;

import imageproc.model.Operation;
import imageproc.operations.chromakey.ChromaKeyOperation;
import imageproc.operations.difference.DifferenceOperation;
import imageproc.operations.extract.ExtractOperation;
import imageproc.operations.grayscale.GrayscaleOperation;
import imageproc.operations.negative.NegativeOperation;
import imageproc.operations.tint.TintOperation;

/**
 *
 * @author childm
 */
public class OperationFactory {

    public enum OpID {
        GRAYSCALE, TINT, CHROMAKEY, NEGATIVE, EXTRACT, DIFFERENCE
    };

    public Operation createOperation(OpID operation) {
        switch (operation) {
            case GRAYSCALE:
                return new GrayscaleOperation();
            case TINT:
                return new TintOperation();
            case CHROMAKEY:
                return new ChromaKeyOperation();
            case NEGATIVE:
                return new NegativeOperation();
            case EXTRACT:
                return new ExtractOperation();
            case DIFFERENCE:
                return new DifferenceOperation();
            default:
                throw new IllegalArgumentException("Unknown operation: " + operation);
        }
    }

}
