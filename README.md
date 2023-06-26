# MP4-to-Text-AI-Transcriber

AI Transcriber is a Java application that utilizes the AssemblyAI API to transcribe audio files in real-time. It provides a graphical user interface (GUI) for users to input the URL of an .mp4 and an API key, and then it retrieves the transcription result from the API.

## Prerequisites

Before using this program, make sure you have the following:

   1. An audio file (in .mp4 format) hosted online, such as a file stored in a GitHub repository. You can use the test samples provided in this program's repository.
```bash
https://raw.githubusercontent.com/mich-wierzch/MP4-to-Text-AI-Transcriber/main/test%20sample.mp4
https://raw.githubusercontent.com/mich-wierzch/MP4-to-Text-AI-Transcriber/main/test_sample%202.mp4
https://raw.githubusercontent.com/mich-wierzch/MP4-to-Text-AI-Transcriber/main/test_sample_3.mp4
```
   2. An API key from AssemblyAI.com. You can register for a free trial without any obligations. The free trial provides you with 5 hours' worth of credit per month, allowing you to transcribe up to 5 hours' worth of audio files.

```bash
https://www.assemblyai.com/dashboard/signup
```

## Usage

    1. Run the Main class in your Java IDE to launch the GUI application.
    2. The GUI window will appear with two input fields:
        URL: Enter the URL of the audio file you want to transcribe.
        API Key: Enter your AssemblyAI API key.
    3. Click the Send Request button to initiate the transcription process.
    4. The program will display the progress of the transcription request in a progress bar.
    5. Once the transcription is complete, the transcribed text will be displayed in the text area.
    6. If any errors occur during the process, an error message will be shown, and the progress bar will turn red.

## Additional Information

The program requires both the URL and API Key fields to be filled in order to work properly.
If the URL or API Key provided is incorrect, the program will return an error.

Please make sure to update tests as appropriate.

![Default_state](https://github.com/mich-wierzch/MP4-to-Text-AI-Transcriber/blob/main/screenshots/preview_1.png)
![Fields_empty](https://github.com/mich-wierzch/MP4-to-Text-AI-Transcriber/blob/main/screenshots/preview_2.png)
![Help_button](https://github.com/mich-wierzch/MP4-to-Text-AI-Transcriber/blob/main/screenshots/preview_3.png)
![Processing](https://github.com/mich-wierzch/MP4-to-Text-AI-Transcriber/blob/main/screenshots/preview_4.png)
![Success](https://github.com/mich-wierzch/MP4-to-Text-AI-Transcriber/blob/main/screenshots/preview_5.png)
![Error](https://github.com/mich-wierzch/MP4-to-Text-AI-Transcriber/blob/main/screenshots/preview_6.png)
## License

[MIT](https://choosealicense.com/licenses/mit/)
