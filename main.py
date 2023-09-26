import deep_learning_pipeline as dlp

model = dlp.load_model(dlp.os.path.join('model', 'water_problem_classifier.h5'))
pipeline = dlp.Model_Pipeline()
answer = pipeline.predict(model)
print(answer)