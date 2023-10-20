public class Model {
    private Viewer viewer;

    public Model(Viewer viewer) {
        this.viewer = viewer;
        RPN rpn = new RPN(this);
    }
}
