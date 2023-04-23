package ChallengeCmd;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Directory {
    private Directory parentDir;
    private String dirName;
    private List<Directory> subdirs;


    public Directory(Directory parentDir, String dirName) {
        this.parentDir = parentDir;
        this.dirName = dirName;
        this.subdirs = new ArrayList<>();
    }

    public void addDir(String dirName) {
        this.subdirs.add(new Directory(this, dirName));
    }

    public String getAbsolutePath() {
        if (this.parentDir == null) {
            return this.dirName;
        }
        Directory dir = this;
        List<String> dirs = new ArrayList<>();
        while (dir != null) {
            dirs.add(dir.dirName);
            dir = dir.parentDir;
        }
        Collections.reverse(dirs);
        return String.join("\\", dirs);
    }

    public Directory getParentDir() {
        return parentDir;
    }

    public String getDirName() {
        return dirName;
    }

    public void setDirName(String dirName) {
        this.dirName = dirName;
    }

    public List<Directory> getSubdirs() {
        return subdirs;
    }

    public void setSubdirs(List<Directory> subdirs) {
        this.subdirs = subdirs;
    }
}
