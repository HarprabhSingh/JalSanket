Refer To this to successfully setup the model in your machine:-

NOTE : This model might take time if you haven't already connected tensorflow with your local machine GPU. So if you want to connect it go through the video link provided below, otherwise CPU will be OK too, but Gpu is generally many times faster than CPU in training the model.
Link of the video : https://www.youtube.com/watch?v=W2EYcpRh7c0

STEP 1 : If you have connected tensorflow with your GPU thorugh above then ONLY INSTALL/USE PYTHON VERSION 3.10 FOR THIS PROJECT. Otherwise, skip this step if you want to train the model using CPU only.

STEP 2 : Inside your main folder which contains all these files, setup virtual environment.

setup virtual environment:-
-> Open your IDE terminal, and use te following commands-
<absolute_path_of_python_version_3.10.exe> -m venv <path_of_your_project_directory + \venv>
->Activate virtual environment-
.\venv\Scripts\activate

You can see a (venv) created in your project directory and also terminal connected with the virtual environment venv. 

STEP 3 : Installing all dependent python libraries. Use the below command in the same terminal :-
pip install -r requirements.txt

STEP 4 : Open main.py and RUN it. You will see the output!!

