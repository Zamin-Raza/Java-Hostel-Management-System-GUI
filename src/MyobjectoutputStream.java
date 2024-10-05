import java.io.File;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class MyobjectoutputStream extends ObjectOutputStream {

    public MyobjectoutputStream(OutputStream o) throws IOException{
        super(o);
    }
    protected MyobjectoutputStream() throws IOException, SecurityException {
        super();
    }

    public MyobjectoutputStream(File f) throws IOException {
        super();

    }

    @Override
    public void writeStreamHeader(){

    }
}