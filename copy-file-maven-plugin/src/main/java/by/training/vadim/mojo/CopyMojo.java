package by.training.vadim.mojo;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Mojo(name = "copy")
public class CopyMojo extends AbstractMojo {

    @Parameter( property = "inputFile")
    private String inputFile;
    @Parameter( property = "outputFile")
    private String outputFile;

    public void execute() throws MojoExecutionException, MojoFailureException{
        try {
            Files.copy(Paths.get(inputFile),Paths.get(outputFile), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
