FROM python:3.8

ENV PYTHONUNBUFFERED 1

RUN apt-get -y update && apt-get -y install vim && apt-get clean && apt-get -y install libgl1-mesa-glx
RUN mkdir /project
ADD . /project

WORKDIR /project
RUN pip install --upgrade pip
RUN pip install -r requirements.txt
RUN pip install opencv-python-headless
RUN python manage.py migrate

EXPOSE 8000
CMD ["python", "manage.py", "runserver", "0.0.0.0:8000"]