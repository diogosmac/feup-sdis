public class DeleteReceiver implements Runnable {

    private String fileId;
    private Peer peer;

    public DeleteReceiver(byte[] message, Peer peer) {
        String messageStr = MyUtils.convertByteArrayToString(message);
        String[] args = messageStr.split(" ");
        this.fileId = args[3];
        this.peer = peer;
    }

    @Override
    public void run() {
        peer.deleteOccurrences(fileId);
        peer.deleteFile(fileId);
    }

}
